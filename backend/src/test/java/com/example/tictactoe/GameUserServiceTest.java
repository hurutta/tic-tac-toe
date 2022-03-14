package com.example.tictactoe;

import static org.mockito.Mockito.when;

import java.util.ArrayList;

import com.example.tictactoe.model.Board;
import com.example.tictactoe.model.Game;
import com.example.tictactoe.model.GameStatus;
import com.example.tictactoe.model.Move;
import com.example.tictactoe.model.PlayerType;
import com.example.tictactoe.model.Query;
import com.example.tictactoe.repository.GameRepository;
import com.example.tictactoe.service.GameServiceImpl;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class GameUserServiceTest 
{
    @InjectMocks
    GameServiceImpl gameServiceImpl;

    @Mock
    GameRepository gameRepository;

    @Test
    public void getAllGameTest()
    {
        ArrayList<Game>arrayList = new ArrayList<Game>();
        Game game1 = new Game(new Board(3, new PlayerType[3][3]), GameStatus.FINISHED, PlayerType.CIRCLE, 5);
        Game game2 = new Game(new Board(4, new PlayerType[4][4]), GameStatus.FINISHED, PlayerType.CROSS, 7);
        Game game3 = new Game(new Board(5, new PlayerType[5][5]), GameStatus.FINISHED, PlayerType.CIRCLE, 9);

        arrayList.add(game1);
        arrayList.add(game2);
        arrayList.add(game3);

        when(gameRepository.findAll()).thenReturn(arrayList);
        Assert.assertEquals(gameServiceImpl.getAllGame(), arrayList);
    }

    @Test
    public void validateCoOrdinatesTest()
    {
        Move move1 = new Move(PlayerType.CIRCLE, 0, 0);
        Move move2 = new Move(PlayerType.CROSS, 4, 5);
        Move move3 = new Move(PlayerType.CROSS, 2, 1);
        Move move4 = new Move(PlayerType.CROSS, 0, 0);

        ArrayList<Move> moves = new ArrayList<Move>();
        moves.add(move1);
        moves.add(move2);

        Assert.assertEquals(false, gameServiceImpl.validateCoOrdinates(moves, 3));

        moves.remove(move2);
        moves.add(move3);
        Assert.assertEquals(true, gameServiceImpl.validateCoOrdinates(moves, 3));

        moves.add(move4);
        Assert.assertEquals(false, gameServiceImpl.validateCoOrdinates(moves, 3));
    }

    @Test
    public void createBoardTest()
    {
        Board board = new Board(4, new PlayerType[4][4]);
        board.setValue(0, 1, PlayerType.CIRCLE);
        board.setValue(2, 1, PlayerType.CROSS);
        board.setValue(3, 2, PlayerType.CIRCLE);

        Move move1 = new Move(PlayerType.CIRCLE, 0, 1);
        Move move2 = new Move(PlayerType.CROSS, 2, 1);
        Move move3 = new Move(PlayerType.CIRCLE, 3, 2);
        ArrayList<Move> moves = new ArrayList<Move>();
        moves.add(move1);
        moves.add(move2);
        moves.add(move3);
        Query query = new Query(4, moves);

        Assert.assertEquals(board.getNxn(), gameServiceImpl.createBoard(query).getNxn());
        Assert.assertArrayEquals(board.getGrid(), gameServiceImpl.createBoard(query).getGrid());
    }

    @Test
    public void validateGameTest()
    {
        ArrayList<Move> moves = new ArrayList<Move>();
        Query query = new Query(4, moves);
        Assert.assertEquals("No moves played yet", gameServiceImpl.validateGame(query));

        Move move1 = new Move(PlayerType.CIRCLE, 0, 1);
        Move move2 = new Move(PlayerType.CROSS, 2, 1);
        Move move3 = new Move(PlayerType.CIRCLE, 2, 3);
        moves.add(move1);
        moves.add(move2);
        moves.add(move3);
        query.setMoves(moves);

        Assert.assertEquals("Not determined, More move possible", gameServiceImpl.validateGame(query));

        Move move4 = new Move(PlayerType.CROSS, 3, 2);
        Move move5 = new Move(PlayerType.CIRCLE, 1, 2);
        moves.add(move4);
        moves.add(move5);
        query.setMoves(moves);
        Assert.assertEquals("CIRCLE wins!", gameServiceImpl.validateGame(query));

    }
}
