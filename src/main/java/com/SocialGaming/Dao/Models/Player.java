package com.SocialGaming.Dao.Models;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Player {
    @Id
    private String email;

    public Player(String email) {
        this.email = email;
    }

    public Player() {

    }

    public void setId(String email) {
        this.email = email;
    }

    public String getId() {
        return email;
    }
}
