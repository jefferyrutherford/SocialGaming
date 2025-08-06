package com.SocialGaming.logging.repository;

import com.SocialGaming.logging.model.ErrorLogs;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ErrorLogsRepository extends JpaRepository<ErrorLogs, Integer> {

    Optional<ErrorLogs> getErrorByErrorMessageAndApiLink(String errorMessage, String apiLink);
}
