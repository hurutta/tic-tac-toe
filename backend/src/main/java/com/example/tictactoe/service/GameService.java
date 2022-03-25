package com.example.tictactoe.service;

import java.util.ArrayList;
import java.util.List;

import com.example.tictactoe.model.Board;
import com.example.tictactoe.model.Game;
import com.example.tictactoe.model.Move;
import com.example.tictactoe.model.PlayerImage;
import com.example.tictactoe.model.Query;

public interface GameService 
{
    public List<Game> getAllGame();
    public String validateGame(Query query);
    public boolean validateCoOrdinates(ArrayList<Move> moves, int nxn);
    public boolean validateSequence(ArrayList<Move> moves);
    public Board createBoard(Query query);    

    public void saveFileName(String fileName);
    public List<PlayerImage> getAllFileName();

}
