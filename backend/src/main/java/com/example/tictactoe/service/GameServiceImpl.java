package com.example.tictactoe.service;

import java.util.ArrayList;
import java.util.List;

import com.example.tictactoe.exception.QueryException;
import com.example.tictactoe.model.Board;
import com.example.tictactoe.model.Game;
import com.example.tictactoe.model.GameStatus;
import com.example.tictactoe.model.Move;
import com.example.tictactoe.model.PlayerImage;
import com.example.tictactoe.model.PlayerType;
import com.example.tictactoe.model.Query;
import com.example.tictactoe.repository.GameRepository;
import com.example.tictactoe.repository.PlayerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameServiceImpl implements GameService
{
    @Autowired
    public GameRepository gameRepository;

    @Autowired
    public PlayerRepository playerRepository;

    public GameServiceImpl(GameRepository gameRepository) 
    {
        this.gameRepository = gameRepository;
    }

    @Override
    public List<Game> getAllGame()
    {
        return gameRepository.findAll();
    }

    @Override
    public String validateGame(Query query) 
    {
        if(query.getNxn() <= 2 || query.getNxn() >12) throw new QueryException("Invalid query");
        if(query.getMoves() == null || query.getMoves().size() == 0) throw new QueryException("No moves provided");
        if(validateSequence(query.getMoves()) == false) throw new QueryException("Moves are not ordered");
        if(validateCoOrdinates(query.getMoves(),query.getNxn()) == false)
        {
            throw new QueryException("Given co-ordinates are repeated OR out of bound");
        }

        Board board = createBoard(query);
        Game game = new Game(board,GameStatus.NEW,null,query.getMoves().size());

        PlayerType winner = VerdictService.checkWinner(game.getBoard()); 
        if(winner == null)
        {
            if(game.getTotalMove() == Math.pow(game.getBoard().getNxn(), 2))
            {
                game.setGameStatus(GameStatus.FINISHED);
                gameRepository.insert(game);
                return "Match draw";
            }else
            {
                return "Not determined, More move possible";
            }
        }else
        {
            game.setGameStatus(GameStatus.FINISHED);
            game.setWinner(winner);
            gameRepository.insert(game);
            return winner + " wins!";
        }
    }

    @Override
    public boolean validateCoOrdinates(ArrayList<Move> moves, int nxn)
    {
        boolean grid[][] = new boolean[nxn][nxn];
        for(int i=0; i<moves.size(); i++)
        {
            if(moves.get(i).getCoOrdinateX() < 0 || moves.get(i).getCoOrdinateX() >= nxn)
            {
                return false;
            }
            if(moves.get(i).getCoOrdinateY() < 0 || moves.get(i).getCoOrdinateY() >= nxn)
            {
                return false;
            }
            if(grid[moves.get(i).getCoOrdinateX()][moves.get(i).getCoOrdinateY()] == true)
            {
                return false;
            }
            grid[moves.get(i).getCoOrdinateX()][moves.get(i).getCoOrdinateY()] = true;
        }
        return true;
    }

    @Override
    public Board createBoard(Query query)
    {
        Board board = new Board();
        board.setNxn(query.getNxn());
        PlayerType grid[][] = new PlayerType[query.getNxn()][query.getNxn()];
        for(int i=0; i<query.getMoves().size(); i++)
        {
            grid[query.getMoves().get(i).getCoOrdinateX()][query.getMoves().get(i)
                    .getCoOrdinateY()] = query.getMoves().get(i).getPlayerType();
        }
        board.setGrid(grid);
        return board;
    }

    @Override
    public boolean validateSequence(ArrayList<Move> moves)
    {
        PlayerType player = moves.get(0).getPlayerType();
        for(int i=1; i<moves.size(); i++)
        {
            PlayerType now = moves.get(i).getPlayerType();
            if(now.equals(player))
            {
                return false;
            }
            player = now;
        }
        return true;
    }

    @Override
    public void saveFileName(String fileName)
    {
        PlayerImage playerImage = new PlayerImage(fileName);
        playerRepository.insert(playerImage);
    }
    @Override
    public List<PlayerImage> getAllFileName()
    {
        return playerRepository.findAll();
    }

}