package com.SocialGaming.Controllers;

import com.SocialGaming.Dao.Models.Tournament;
import com.SocialGaming.Dao.TournamentRepo;
import com.SocialGaming.Dao.Models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class TournamentController {

    @Autowired
    TournamentRepo tournamentRepo;


    @GetMapping("/tournament")
    public List<Tournament> helloWorld(){
        User newPlayer = new User("jefferyrutherfordTestAgain@outlook.com");
        List<Tournament> tournaments = tournamentRepo.findAll();
        //System.out.println(tournaments.toString());
        return tournaments;
    }


}
