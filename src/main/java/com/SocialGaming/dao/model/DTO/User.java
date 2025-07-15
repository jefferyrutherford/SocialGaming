package com.SocialGaming.dao.model.DTO;

public class User {
    private String userID;
    private String email;

    public User(String userID, String email) {
        this.userID = userID;
        this.email = email;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public com.SocialGaming.dao.model.User toUserDTO() {
        return new com.SocialGaming.dao.model.User(this.email, this.userID);
    }

    public User fromUserDTO(com.SocialGaming.dao.model.User u) {
        return new User(u.getUserID(), u.getEmail());
    }

}
