package com.example.tictactoe.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "playerImage")
public class PlayerImage
{
    @Id
    private String playerId;
    private String playerImageFileName;
    public PlayerImage()
    {
        super();
    }

    public PlayerImage(String playerImageFileName)
    {
        this.playerImageFileName = playerImageFileName; 
    }
    

    /**
     * @return String return the playerId
     */
    public String getPlayerId() {
        return playerId;
    }

    /**
     * @param playerId the playerId to set
     */
    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }

    /**
     * @return String return the playerImageFileName
     */
    public String getPlayerImageFileName() {
        return playerImageFileName;
    }

    /**
     * @param playerImageFileName the playerImageFileName to set
     */
    public void setPlayerImageFileName(String playerImageFileName) {
        this.playerImageFileName = playerImageFileName;
    }

}
