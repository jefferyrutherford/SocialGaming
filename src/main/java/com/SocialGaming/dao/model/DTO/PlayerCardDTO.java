package com.SocialGaming.dao.model.DTO;

import org.springframework.beans.factory.annotation.Autowired;

public class PlayerCardDTO {

    private String userID;
    private int playerCardID;
    private String title;

    PlayerCardDTO() {}


    public PlayerCardDTO(String userID, int playerCardID, String title) {
        this.userID = userID;
        this.playerCardID = playerCardID;
        this.title = title;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUserID() {
        return userID;
    }

    public void setPlayerCardID(int playerCardID) {
        this.playerCardID = playerCardID;
    }

    public int getPlayerCardID() {
        return playerCardID;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }
}
