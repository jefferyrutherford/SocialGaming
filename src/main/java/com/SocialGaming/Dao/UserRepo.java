package com.SocialGaming.Dao;

import com.SocialGaming.Dao.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,String> {
}
