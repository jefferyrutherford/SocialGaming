package com.SocialGaming.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("profile")
public class ProfileController {
        @GetMapping("/")
        String helloworld() {
            return "Profile World From Jeff";
        }
}
