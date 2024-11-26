package com.SocialGaming.Controllers;

import com.SocialGaming.Dao.Models.User;
import com.SocialGaming.Dao.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class PlayerController {

    @Autowired
    UserRepo userRepo;


    @RequestMapping("/newPlayer")
    public String helloWorld(){
        User newPlayer = new User("jefferyrutherfordTestAgain@outlook.com");
        userRepo.save(newPlayer);
        return "New Player";
    }


}
