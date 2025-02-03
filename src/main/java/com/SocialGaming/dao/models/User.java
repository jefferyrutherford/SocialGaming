package com.SocialGaming.dao.models;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class User {
    @Id
    private String email;

    private String userID;

    public User(String email, String userID) {
        this.email = email;
        this.userID = userID;
    }

    public User() {

    }

    public User(String mail) {
        this.email = mail;
    }

    public void setId(String email) {
        this.email = email;
    }

    public String getId() {
        return email;
    }
}
