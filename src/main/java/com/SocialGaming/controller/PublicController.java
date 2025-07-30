package com.SocialGaming.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/public")
public class PublicController {
    @GetMapping("/test")
    public String test() {
        return "Hello Admin World";
    }

    @GetMapping("/testFail")
    public String fail() {
        throw new RuntimeException("fail() endpoint");
    }
}
