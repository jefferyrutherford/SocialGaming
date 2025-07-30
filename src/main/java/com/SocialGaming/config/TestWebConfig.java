package com.SocialGaming.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;
import java.util.List;

@Configuration
@Profile({"test"})
public class TestWebConfig {
    @Value("${cors.allowed-origins}")
    private String AllowedOrigins;

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        List<String> allowedOrigins = Arrays.asList(AllowedOrigins.split(","));

        CorsConfiguration config = new CorsConfiguration();
        // Update this when deploying to test environment
        config.setAllowedOrigins(allowedOrigins);
        config.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        config.setAllowedHeaders(List.of("*"));
        config.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);
        return source;
    }
}