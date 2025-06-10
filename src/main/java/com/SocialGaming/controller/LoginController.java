package com.SocialGaming.controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.http.HttpResponse;

@RestController
public class LoginController {


    @PostMapping("/login")
    public HttpResponse loginUser(@RequestParam(name = "code") String code) throws IOException, InterruptedException {

        return null;
    }



}
