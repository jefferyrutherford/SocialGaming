package com.SocialGaming.dao.service;

import com.SocialGaming.dao.UserRepo;
import com.SocialGaming.dao.model.User;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Objects;

@Service
public class UserService {
    private final UserRepo userRepository;

    public UserService(UserRepo userRepository) {
        this.userRepository = userRepository;
    }

    public com.SocialGaming.dao.model.DTO.User login(String email, String userID) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!Objects.equals(user.getUserID(), userID) || !Objects.equals(user.getEmail(), email)) {
            throw new RuntimeException("Wrong email or password");
        }

        user.setLastLoggedIn(LocalDateTime.now());

        userRepository.save(user);
        return new com.SocialGaming.dao.model.DTO.User(user.getUserID(), user.getEmail());
    }
}

