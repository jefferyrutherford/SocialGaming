package com.SocialGaming.dao.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class PlayerCard {

    @Id
    @Column(name = "UserID", nullable = false, unique = true)
    private String userID;


    /*
    @MapsId links user and userID (shared primary key)
    @JoinColumn(name = "UserID") defines the FK
     */
    @OneToOne
    @MapsId // Tells Hibernate: use the same ID for the relationship
    @JoinColumn(name = "UserID")
    private User user;

    @Column(name = "PhotoID", nullable = false)
    private int photoID;

    @Column(name = "Title", nullable = false)
    private String title;


    public PlayerCard(String userID, int photoID, String title) {
        this.userID = userID;
        this.photoID = photoID;
        this.title = title;
    }

    public PlayerCard() {

    }

    public String getUserID() {
        return this.userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public int getPhotoID() {
        return this.photoID;
    }

    public void setPhotoID(int photoID) {
        this.photoID = photoID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        PlayerCard that = (PlayerCard) o;
        return photoID == that.photoID && Objects.equals(userID, that.userID) && Objects.equals(title, that.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userID, photoID, title);
    }
}
