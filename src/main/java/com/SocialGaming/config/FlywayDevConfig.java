package com.SocialGaming.config;

import org.flywaydb.core.Flyway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.sql.DataSource;

@Configuration
@Profile("dev")
public class FlywayDevConfig {
    private final DataSource dataSource;

    public FlywayDevConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    // Begin flyway for the main Schema
    @Bean(name = "flywayMain", initMethod = "migrate")
    public Flyway flywayMain() {
        return Flyway.configure()
                .dataSource(dataSource)
                .schemas("db")
                .locations("classpath:db/migration/main")
                .load();
    }

    // Begin logging flyway schema
    @Bean(name = "flywayLogging", initMethod = "migrate")
    public Flyway flywayLogging() {
        return Flyway.configure()
                .dataSource(dataSource)
                .schemas("logging")
                .locations("classpath:db/migration/logging")
                .load();
    }
}
