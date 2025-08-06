package com.SocialGaming.logging.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "ErrorLogs")
@Getter
@Setter
@NoArgsConstructor
public class ErrorLogs {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;


    @Column(name="api_link")
    private String apiLink;

    @Column(name="error_message")
    private String errorMessage;

    @Column(nullable = false)
    private Integer count = 1;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();
}
