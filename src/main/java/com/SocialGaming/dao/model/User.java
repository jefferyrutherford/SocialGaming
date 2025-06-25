package com.SocialGaming.dao.model;


import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class User {

    @Column(nullable = false, unique = true, name = "Email")
    private String email;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UserID", nullable = false)
    private String userID;


    @Column(name = "LastLoggedIn")
    private LocalDateTime lastLoggedIn;

    public User(String email, String userID, LocalDateTime lastLoggedIn) {
        this.email = email;
        this.userID = userID;
        this.lastLoggedIn = lastLoggedIn;
    }

    public User() {

    }

    public User(String email, String userID) {
        this.email = email;
        this.userID = userID;
    }

    public User(String mail) {
        this.email = mail;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUserID() {
        return userID;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return this.email;
    }

    public void setLastLoggedIn(LocalDateTime lastLoggedIn) {
        this.lastLoggedIn = lastLoggedIn;
    }

    public void setLastLoggedIn() {
        this.lastLoggedIn = LocalDateTime.now();
    }

    public LocalDateTime getLastLoggedIn() {
        return lastLoggedIn;
    }
}
