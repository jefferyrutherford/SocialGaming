package com.SocialGaming.Dao;

import com.SocialGaming.Dao.Models.Tournament;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TournamentRepo extends JpaRepository<Tournament, Integer> {
}
