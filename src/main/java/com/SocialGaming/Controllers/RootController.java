package com.SocialGaming.Controllers;

import org.springframework.web.bind.annotation.GetMapping;

public class RootController {
    @GetMapping("/")
    String helloworld() {
        return "Hello World";
    }
}
