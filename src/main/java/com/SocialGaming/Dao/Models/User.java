package com.SocialGaming.Dao.Models;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class User {
    @Id
    private String email;

    public User(String email) {
        this.email = email;
    }

    public User() {

    }

    public void setId(String email) {
        this.email = email;
    }

    public String getId() {
        return email;
    }
}
