package com.SocialGaming.config;


import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;


import javax.sql.DataSource;

@Configuration
@Profile("dev")
@EnableTransactionManagement
@EnableJpaRepositories (
        basePackages = "com.SocialGaming.logging.repository",
        entityManagerFactoryRef = "loggingEntityManager",
        transactionManagerRef = "loggingTransactionManager"
)
public class DevLoggingJPAConfig {

/*    @Primary
    @Bean(name = "defaultDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.url")
    public DataSource defaultDataSource() {
        return DataSourceBuilder.create().build();
    }*/

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.logging")
    public DataSource loggingDatasource() {
        return DataSourceBuilder.create().build();
    }


    @Bean(name = "loggingEntityManager")
    public LocalContainerEntityManagerFactoryBean loggingEntityManager(
            EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(loggingDatasource())
                .packages("com.SocialGaming.logging.model")
                .persistenceUnit("loggingPU")
                .build();
    }

    @Bean(name = "loggingTransactionManager")
    public PlatformTransactionManager loggingTransactionManager(
            @Qualifier("loggingEntityManager")EntityManagerFactory loggingEntitntyManager) {
        return new JpaTransactionManager(loggingEntitntyManager);
    }
}
