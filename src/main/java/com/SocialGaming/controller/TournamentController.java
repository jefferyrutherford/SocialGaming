package com.SocialGaming.controller;

import com.SocialGaming.dao.model.Tournament;
import com.SocialGaming.dao.TournamentRepo;
import com.SocialGaming.dao.model.User;
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
        return tournamentRepo.findAll();
    }


}
