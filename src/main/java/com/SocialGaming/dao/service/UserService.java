package com.SocialGaming.dao.service;

import com.SocialGaming.dao.PlayerCardRepo;
import com.SocialGaming.dao.UserRepo;
import com.SocialGaming.dao.model.DTO.PlayerCardDTO;
import com.SocialGaming.dao.model.PlayerCard;
import com.SocialGaming.dao.model.User;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepo userRepository;
    private final PlayerCardRepo playerCardRepo;

    public UserService(UserRepo userRepository, PlayerCardRepo playerCardRepo) {
        this.userRepository = userRepository;
        this.playerCardRepo = playerCardRepo;
    }

    public com.SocialGaming.dao.model.DTO.User login(String email, String userID) {
        User user = userRepository.findByEmail(email)
                .orElse(signUp(email, userID));

        if (!Objects.equals(user.getUserID(), userID) || !Objects.equals(user.getEmail(), email)) {
            throw new RuntimeException("Wrong email or password");
        }

        user.setLastLoggedIn(LocalDateTime.now());

        userRepository.save(user);
        return new com.SocialGaming.dao.model.DTO.User(user.getUserID(), user.getEmail());
    }

    public User signUp(String email, String userID) {
        try {
            return userRepository.save(new User(email, userID));
        } catch (Exception e) {
            throw new RuntimeException("Sign up failed for the new user: " + email);
        }
    }

    public PlayerCardDTO getPlayerCard(String userID) {
        Optional<PlayerCard> playerCard = playerCardRepo.findPlayerCardByUserID(userID);
        PlayerCardDTO dto = new PlayerCardDTO(playerCard.get());
        return dto;
    }
}

