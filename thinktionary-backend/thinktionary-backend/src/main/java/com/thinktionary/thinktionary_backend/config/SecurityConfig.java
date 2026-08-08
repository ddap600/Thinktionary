package com.thinktionary.thinktionary_backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {

        // TODO: Replace permitAll() with JWT authentication and authorization rules.
        // Authentication will be implemented later.
        // For now, allow all requests while building the application.
        httpSecurity
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().permitAll()
                );

        return httpSecurity.build();
    }
}
