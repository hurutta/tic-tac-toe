package com.example.tictactoe.service;

import com.example.tictactoe.model.Board;
import com.example.tictactoe.model.PlayerType;

public class VerdictService
{
    public static PlayerType checkWinner(Board board)
    {
        Boolean crossWinner = verdict(board, PlayerType.CROSS); 
        Boolean circleWinner = verdict(board, PlayerType.CIRCLE);
        if(crossWinner && circleWinner) return PlayerType.BOTH;
        if(crossWinner) return PlayerType.CROSS;
        if(circleWinner) return PlayerType.CIRCLE;
        return null;
    }

    public static Boolean verdict(Board board,PlayerType playerType)
    {
        int row, col;
        row = col = board.getNxn();
        for(int i=0; i<row; i++)
        {
            int consecutive3counterRow = 0;
            int consecutive3counterCol = 0;
            for(int k=0; k<col; k++)
            {
                //row wise checking for consecutive 3 same player
                if(board.getValue(i,k) == playerType) consecutive3counterRow++;
                else consecutive3counterRow = 0;
                if(consecutive3counterRow == 3) return true;

                //column wise checking for consecutive 3 same player
                if(board.getValue(k, i) == playerType) consecutive3counterCol++;
                else consecutive3counterCol = 0;
                if(consecutive3counterCol == 3) return true;
            }

        }
        int len = 1;
        int xval = row-1;
        int yval = 0;
        int zval = 0;
        for(int i=0; i<(row*2)-1; i++)
        {
            int consecutive3counterDiagonalX = 0;
            for(int k=0,xx=xval,yy=yval; k<len; k++,xx++,yy++)
            {
                //diagonal wise checking for consecutive 3 same player (left to right)
                if(board.getValue(xx,yy) == playerType) consecutive3counterDiagonalX++;
                else consecutive3counterDiagonalX = 0;
                if(consecutive3counterDiagonalX == 3) return true;
            }
            int consecutive3counterDiagonalY = 0;
            for(int k=0,xx=yval,yy=zval; k<len; k++,xx++,yy--)
            {
                //diagonal wise checking for consecutive 3 same player (right to left)
                if(board.getValue(xx,yy) == playerType) consecutive3counterDiagonalY++;
                else consecutive3counterDiagonalY = 0;
                if(consecutive3counterDiagonalY == 3) return true;
            }

            xval--;
            zval++;
            if(xval < 0) xval = 0;
            if(i < row-1) len++;
            else
            {
                zval--;
                len--;
                yval++;
            }
        }
        return false;
    }
}
