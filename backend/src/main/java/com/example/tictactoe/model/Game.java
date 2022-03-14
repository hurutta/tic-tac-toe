package com.example.tictactoe.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "game")
public class Game 
{
    @Id
    private String gameId;
    private Board board;
    private GameStatus gameStatus;
    private PlayerType winner;
    private int totalMove = 0;
    public Game()
    {
        super();
    }

    
    public Game(Board board, GameStatus gameStatus, PlayerType winner, int totalMove)
    {
        this.board = board;
        this.gameStatus = gameStatus;
        this.winner = winner;
        this.totalMove = totalMove;
    }
    
    public String getGameId() 
    {
        return gameId;
    }
    public void setGameId(String gameId) {
        this.gameId = gameId;
    }
    public Board getBoard() {
        return board;
    }
    public void setBoard(Board board) {
        this.board = board;
    }
    public GameStatus getGameStatus() {
        return gameStatus;
    }
    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

    public PlayerType getWinner() {
        return winner;
    }
    public void setWinner(PlayerType winner) {
        this.winner = winner;
    }
    public int getTotalMove() {
        return totalMove;
    }
    public void setTotalMove(int totalMove) {
        this.totalMove = totalMove;
    }
    
}
