package com.meinname.kochbuch; // Passe das an dein echtes Package an!

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf().disable()  // Deaktiviert CSRF-Schutz (für Postman sinnvoll)
            .authorizeHttpRequests(auth -> auth
                .anyRequest().permitAll()  // Erlaubt alle Anfragen
            );
        return http.build();
    }
}
