package com.SocialGaming.Dao;

import com.SocialGaming.Dao.Models.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepo extends JpaRepository<Player,String> {
}
