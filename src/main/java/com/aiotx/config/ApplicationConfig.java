package com.aiotx.config;

import com.aiotx.EmailService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Bean
    public EmailService emailService() {
        return new EmailService();
    }
}
