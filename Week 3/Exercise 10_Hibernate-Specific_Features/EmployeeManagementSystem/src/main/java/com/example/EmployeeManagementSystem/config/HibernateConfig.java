package com.example.EmployeeManagementSystem.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaAuditing
@EnableJpaRepositories(basePackages = "com.example.EmployeeManagementSystem.repository")
public class HibernateConfig {

    @Bean
    public org.hibernate.cfg.Configuration hibernateConfiguration() {
        org.hibernate.cfg.Configuration configuration = new org.hibernate.cfg.Configuration();
        configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
        configuration.setProperty("hibernate.jdbc.batch_size", "30");
        configuration.setProperty("hibernate.order_inserts", "true");
        configuration.setProperty("hibernate.order_updates", "true");
        return configuration;
    }
}
