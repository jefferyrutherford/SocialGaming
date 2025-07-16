package com.SocialGaming.dao;

import com.SocialGaming.dao.model.PlayerCard;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PlayerCardRepo extends JpaRepository<PlayerCard, String> {
    Optional<PlayerCard> findPlayerCardByUserID(String userID);
}
