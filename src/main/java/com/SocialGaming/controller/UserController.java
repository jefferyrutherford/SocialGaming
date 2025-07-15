package com.SocialGaming.controller;

import com.SocialGaming.dao.model.User;
import com.SocialGaming.dao.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;


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
    public List<User> getAll(@RequestHeader Map<String, String> headers) {
        headers.forEach((key, value) -> System.out.println("Header: " + key + " Value: " + value));
        //return ResponseEntity.ok("Headers printed to console");
        return userRepo.findAll();
    }

    @RequestMapping("/tester")
    public String tester() {
        return "TESTER Lets Go!!!!!!!!!!1";
    }

    @RequestMapping("/getPlayerCard")
    public String getPlayerCard() {
        return "test";
    }


}
