package com.SocialGaming.controller;

import com.SocialGaming.dao.models.User;
import com.SocialGaming.dao.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    UserRepo userRepo;


    @RequestMapping("/newUser")
    public String helloWorld(){
        User newPlayer = new User("jefferyrutherfordTestAgain@outlook.com");
        userRepo.save(newPlayer);
        return "New User";
    }


    @RequestMapping("/getAll")
    public List<User> getAll() {
        return userRepo.findAll();
    }

    @RequestMapping("/tester")
    public String tester() {
        return "TESTER Lets Go!!!!!!!!!!1";
    }


}
