package com.SocialGaming.Controllers;

import com.SocialGaming.Dao.Models.Player;
import com.SocialGaming.Dao.PlayerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class PlayerController {

    @Autowired
    PlayerRepo playerRepo;


    @RequestMapping("/newPlayer")
    public String helloWorld(){
        Player newPlayer = new Player("jefferyrutherford@outlook.com");
        playerRepo.save(newPlayer);
        return "New Player";
    }


}
