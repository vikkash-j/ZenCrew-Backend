package com.hrms.zencrew.security;

import java.io.IOException;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtService jwtService;
    private final UserDetailsService userDetailsService;

    public JwtAuthenticationFilter(
            JwtService jwtService,
            UserDetailsService userDetailsService) {

        this.jwtService = jwtService;
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain)
            throws ServletException, IOException {

        final String authHeader = request.getHeader("Authorization");

        // No JWT token
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }

        // Remove "Bearer " from the header
        final String jwtToken = authHeader.substring(7);

        try {

            // Extract email from JWT
            final String email = jwtService.extractEmail(jwtToken);

            // Authenticate user
            if (email != null
                    && SecurityContextHolder.getContext().getAuthentication() == null) {

                UserDetails userDetails =
                        userDetailsService.loadUserByUsername(email);
                System.out.println("JWT Email: " + email);
                System.out.println("User Authorities: " + userDetails.getAuthorities());

                // Validate JWT
                if (jwtService.isTokenValid(jwtToken, userDetails)) {

                    UsernamePasswordAuthenticationToken authentication =
                            new UsernamePasswordAuthenticationToken(
                                    userDetails,
                                    null,
                                    userDetails.getAuthorities()
                            );

                    authentication.setDetails(
                            new WebAuthenticationDetailsSource()
                                    .buildDetails(request)
                    );

                    SecurityContextHolder.getContext()
                            .setAuthentication(authentication);
                }
            }

        } catch (Exception e) {

            // Invalid or expired JWT
            System.out.println("JWT validation failed: " + e.getMessage());

            SecurityContextHolder.clearContext();
        }

        // Continue the request
        filterChain.doFilter(request, response);
    }
      
}