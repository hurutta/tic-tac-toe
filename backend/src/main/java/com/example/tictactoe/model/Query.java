package com.example.tictactoe.model;

import java.util.ArrayList;

public class Query 
{
    private int nxn;
    private ArrayList<Move> moves;
    
    public Query()
    {
        super();
    }

    public Query(int nxn, ArrayList<Move> moves)
    {
        this.nxn = nxn;
        this.moves = moves;
    }
    

    public int getNxn() {
        return nxn;
    }

    public void setNxn(int nxn) {
        this.nxn = nxn;
    }

    public ArrayList<Move> getMoves() {
        return moves;
    }

    public void setMoves(ArrayList<Move> moves) {
        this.moves = moves;
    }

}
