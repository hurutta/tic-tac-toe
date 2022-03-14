package com.example.tictactoe.model;


public class Board 
{
    private int nxn;
    private PlayerType grid[][];
    
    public Board()
    {
        super();
    }

    public Board(int nxn,PlayerType grid[][])
    {
        super();
        this.nxn = nxn;
        this.grid = grid;
    }

    public PlayerType getValue(int xx,int yy)
    {
        return grid[xx][yy];
    }

    public void setValue(int xx,int yy,PlayerType playerType)
    {
        grid[xx][yy] = playerType;
    }

    public int getNxn() 
    {
        return nxn;
    }

    public void setNxn(int nxn) 
    {
        this.nxn = nxn;
    }

    public PlayerType[][] getGrid() 
    {
        return grid;
    }

    public void setGrid(PlayerType grid[][]) 
    {
        this.grid = grid;
    }

}

