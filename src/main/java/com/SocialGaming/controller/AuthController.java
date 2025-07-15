package com.SocialGaming.controller;

import com.SocialGaming.dao.model.DTO.User;
import com.SocialGaming.dao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.security.core.Authentication;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;


@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    UserService userService;

    @PostMapping("/authenticated")
    public ResponseEntity<User> authenticated() throws IOException, InterruptedException {
        try {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            if (auth == null) {
                System.out.println("Authentication is null");
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
            }

            if (!(auth instanceof JwtAuthenticationToken)) {
                System.out.println("Authentication is not JwtAuthenticationToken: " + auth.getClass().getName());
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
            }

            Jwt jwt = ((JwtAuthenticationToken) auth).getToken();
            if (jwt == null) {
                System.out.println("Jwt is null in JwtAuthenticationToken");
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
            }


            return ResponseEntity.ok( userService.login(jwt.getClaimAsString("email"), jwt.getClaimAsString("cognito:username")));
            // Access JWT claims here
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
}
