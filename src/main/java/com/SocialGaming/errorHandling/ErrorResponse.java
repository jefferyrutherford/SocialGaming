package com.SocialGaming.errorHandling;

import java.time.LocalDateTime;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;



@Data
@NoArgsConstructor

public class ErrorResponse {
    private String message;
    private String details;
    private LocalDateTime time;


    public ErrorResponse (String message, String details, LocalDateTime time) {
        this.message = message;
        this.details = details;
        this.time = time;
    }

    public ErrorResponse(String message, String details) {
        this.message = message;
        this.details = details;
        this.time = LocalDateTime.now();
    }
}
