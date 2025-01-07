package com.SocialGaming.Controllers;

import com.SocialGaming.Dao.Models.User;
import com.SocialGaming.Dao.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("User")
public class PlayerController {

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
