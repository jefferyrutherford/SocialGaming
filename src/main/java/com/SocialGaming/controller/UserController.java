package com.SocialGaming.controller;

import com.SocialGaming.dao.model.DTO.PlayerCardDTO;
import com.SocialGaming.dao.model.User;
import com.SocialGaming.dao.UserRepo;
import com.SocialGaming.dao.service.UserService;
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

    @Autowired
    UserService userService;



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
    public PlayerCardDTO getPlayerCard() {
        return userService.getPlayerCard("e10bb590-5051-7079-f569-96e8246c917c");
    }


}
