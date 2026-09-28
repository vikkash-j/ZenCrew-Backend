package com.hrms.zencrew.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import com.hrms.zencrew.security.JwtAuthenticationFilter;

@Configuration
public class SecurityConfig {

    private final UserDetailsService userDetailsService;
    private final PasswordEncoder passwordEncoder;
    private final JwtAuthenticationFilter jwtAuthenticationFilter;

    public SecurityConfig(
            UserDetailsService userDetailsService,
            PasswordEncoder passwordEncoder,
            JwtAuthenticationFilter jwtAuthenticationFilter) {

        this.userDetailsService = userDetailsService;
        this.passwordEncoder = passwordEncoder;
        this.jwtAuthenticationFilter = jwtAuthenticationFilter;
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {

        DaoAuthenticationProvider provider =
                new DaoAuthenticationProvider();

        provider.setUserDetailsService(userDetailsService);

        // Use BCrypt to verify the password
        provider.setPasswordEncoder(passwordEncoder);

        return provider;
    }

    @Bean
    public AuthenticationManager authenticationManager(
            AuthenticationConfiguration configuration)
            throws Exception {

        return configuration.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(
            HttpSecurity http,
            AuthenticationProvider authenticationProvider)
            throws Exception {

    	http
        .csrf(csrf -> csrf.disable())

        .sessionManagement(session ->
            session.sessionCreationPolicy(
                SessionCreationPolicy.STATELESS
            )
        )

        .authenticationProvider(authenticationProvider)

        .addFilterBefore(
            jwtAuthenticationFilter,
            UsernamePasswordAuthenticationFilter.class
        )

        .authorizeHttpRequests(auth -> auth

        	    // Login is public
        	    .requestMatchers("/api/auth/login").permitAll()

        	    // Department APIs
        	    .requestMatchers(
        	        "/api/departments/create",
        	        "/api/departments/update/**",
        	        "/api/departments/delete/**"
        	    ).hasRole("ADMIN")

        	    // Employee APIs
        	    .requestMatchers(
        	        "/api/employees/create",
        	        "/api/employees/update/**",
        	        "/api/employees/delete/**"
        	    ).hasRole("ADMIN")

        	    // Read APIs
        	    .requestMatchers(
        	        "/api/departments/**",
        	        "/api/employees/**"
        	    ).hasAnyRole("ADMIN", "EMPLOYEE")

        	    // Everything else
        	    .anyRequest().authenticated()
        	);       
    	return http.build();
    }
}