/*
package com.SocialGaming.config;

import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.sql.DataSource;

@Configuration
@Profile("dev")
public class FlywayDevConfig {


    private final @Qualifier("dataSource") DataSource defaultDataSource;
    private final  @Qualifier("loggingDatasource") DataSource loggingDataSource;

    public FlywayDevConfig( DataSource defaultDataSource, DataSource loggingDataSource) {
        this.defaultDataSource = defaultDataSource;
        this.loggingDataSource = loggingDataSource;
    }




    // Begin flyway for the main Schema
    @Bean(name = "flywayMain", initMethod = "migrate")
    public Flyway flywayMain() {
        return Flyway.configure()
                .dataSource(this.defaultDataSource)
                .schemas("db")
                .locations("classpath:db/migration/main")
                .load();
    }

    // Begin logging flyway schema
    @Bean(name = "flywayLogging", initMethod = "migrate")
    public Flyway flywayLogging() {
        return Flyway.configure()
                .dataSource(this.loggingDataSource)
                .schemas("logging")
                .locations("classpath:db/migration/logging")
                .load();
    }
}
*/
