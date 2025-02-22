package com.SocialGaming.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @GetMapping("/")
    String helloworld() {
        return "Hello World";
    }
    @GetMapping("/secured")
    public String secured() {
        return "Hello Secured";
    }

}
