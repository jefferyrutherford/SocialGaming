package com.SocialGaming.dao;

import com.SocialGaming.dao.model.Tournament;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TournamentRepo extends JpaRepository<Tournament, Integer> {
}
