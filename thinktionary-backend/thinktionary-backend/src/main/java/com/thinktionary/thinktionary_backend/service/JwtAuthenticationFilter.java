package com.thinktionary.thinktionary_backend.service;

import com.thinktionary.thinktionary_backend.security.CustomUserDetailsService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtService jwtService;
    private final CustomUserDetailsService customUserDetailsService;

    public JwtAuthenticationFilter(
            JwtService jwtService,
            CustomUserDetailsService customUserDetailsService
    ) {
        this.jwtService = jwtService;
        this.customUserDetailsService = customUserDetailsService;
    }

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain
    ) throws ServletException, IOException {


        // Checks the request Authorization Header for a Bearer token.
        // If it doesn't find one, it passes the request on to the filter chain without authenticating the request.
        final String authHeader = request.getHeader("Authorization");

        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }

        // A Bearer token was found.
        // Extract the JWT from the Authorization header.
        String jwtToken = authHeader.substring(7);   // "Bearer "

        // TODO: Extracting username before validating the token can lead to unexpected exceptions. Handle these.
        String username = jwtService.extractUsername(jwtToken);

        // Only authenticate the request if:
        // 1. A username was successfully extracted.
        // 2. The request has not already been authenticated.
        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {

            UserDetails userDetails = customUserDetailsService.loadUserByUsername(username);

            if (jwtService.isTokenValid(jwtToken, userDetails)) {

                UsernamePasswordAuthenticationToken authToken =
                        new UsernamePasswordAuthenticationToken(
                                userDetails,
                                null,
                                userDetails.getAuthorities()
                        );

                SecurityContextHolder.getContext().setAuthentication(authToken);
            }
        }

        // Sends the request to the rest of the filter chain (even if not authenticated).
        //
        // If the endpoint requires authentication and no valid authentication
        // was established, Spring Security will reject the request later.
        filterChain.doFilter(request, response);

    }
}
