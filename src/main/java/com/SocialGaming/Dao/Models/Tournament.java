package com.SocialGaming.Dao.Models;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Tournament {
    @Id
    private int TournamentID;

    private int GameID;
    private String Title;
    //private String StartDateTime;
    //private String EndDateTime;

    public Tournament(int tournamentID, int gameID, String title) {
        this.TournamentID = tournamentID;
        this.GameID = gameID;
        this.Title = title;
    }

    public Tournament() {

    }

    public void setId(int tournamentID) {
        this.TournamentID = tournamentID;
    }

    public int getId() {
        return this.TournamentID;
    }


    public void setGameID(int gameID) {this.GameID = gameID;};
    public int getGameID() { return this.GameID;};


    public void setTitle(String title) {this.Title = title;};
    public String getTitle() {return this.Title;};
}
