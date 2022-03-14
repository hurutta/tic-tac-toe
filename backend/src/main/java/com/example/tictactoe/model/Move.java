package com.example.tictactoe.model;

public class Move 
{
    private PlayerType playerType;
    private int coOrdinateX;
    private int coOrdinateY;
    
    public Move(PlayerType playerType, int coOrdinateX, int coOrdinateY)
    {
        this.playerType = playerType;
        this.coOrdinateX = coOrdinateX;
        this.coOrdinateY = coOrdinateY;
    }


    public PlayerType getPlayerType() {
        return playerType;
    }
    public void setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
    }
    public int getCoOrdinateX() {
        return coOrdinateX;
    }
    public void setCoOrdinateX(int coOrdinateX) {
        this.coOrdinateX = coOrdinateX;
    }
    public int getCoOrdinateY() {
        return coOrdinateY;
    }
    public void setCoOrdinateY(int coOrdinateY) {
        this.coOrdinateY = coOrdinateY;
    }

}
