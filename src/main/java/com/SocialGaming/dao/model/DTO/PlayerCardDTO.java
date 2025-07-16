package com.SocialGaming.dao.model.DTO;

import com.SocialGaming.dao.model.PlayerCard;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Objects;

public class PlayerCardDTO {

    private String userID;
    private int photoID;
    private String title;

    PlayerCardDTO() {}

    public PlayerCardDTO(PlayerCard playerCard) {
        this.userID = playerCard.getUserID();
        this.photoID = playerCard.getPhotoID();
        this.title = playerCard.getTitle();
    }


    public PlayerCardDTO(String userID, int playerCardID, String title) {
        this.userID = userID;
        this.photoID = playerCardID;
        this.title = title;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUserID() {
        return userID;
    }

    public void setPhotoID(int photoID) {
        this.photoID = photoID;
    }

    public int getPhotoID() {
        return photoID;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        PlayerCardDTO that = (PlayerCardDTO) o;
        return photoID == that.photoID && Objects.equals(userID, that.userID) && Objects.equals(title, that.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userID, photoID, title);
    }


}
