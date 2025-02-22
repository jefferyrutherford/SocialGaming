package com.SocialGaming.dao;

import com.SocialGaming.dao.models.Tournament;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TournamentRepo extends JpaRepository<Tournament, Integer> {
}
