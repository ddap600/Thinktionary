package com.thinktionary.thinktionary_backend.service;

import com.thinktionary.thinktionary_backend.dto.AuthLoginRequestDto;
import com.thinktionary.thinktionary_backend.dto.AuthResponseDto;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public AuthService(
            AuthenticationManager authenticationManager,
            JwtService jwtService) {
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
    }

    public AuthResponseDto loginUser(AuthLoginRequestDto authLoginRequestDto) {

        Authentication authentication =
                authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(
                                authLoginRequestDto.getUsername(),
                                authLoginRequestDto.getPassword()
                        )
                );

        String token = jwtService.generateToken(
                (UserDetails) authentication.getPrincipal()
        );

        return new AuthResponseDto(
                true,
                token
        );
    }
}
