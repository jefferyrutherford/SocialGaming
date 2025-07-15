package com.SocialGaming.controller;

import com.SocialGaming.dao.UserRepo;
import com.SocialGaming.dao.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    UserRepo userRepo;

    @GetMapping("/getUsers")
    public List<User> test() {
        return userRepo.findAll();
    }
}
