package com.thinktionary.thinktionary_backend.service;

import com.thinktionary.thinktionary_backend.dto.AuthLoginRequestDto;
import com.thinktionary.thinktionary_backend.dto.AuthResponseDto;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final AuthenticationManager authenticationManager;

    public AuthService(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    public AuthResponseDto loginUser(AuthLoginRequestDto authLoginRequestDto) {

        Authentication authentication =
                authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(
                                authLoginRequestDto.getUsername(),
                                authLoginRequestDto.getPassword()
                        )
                );

        return new AuthResponseDto(
                true,
                "placeholder"
        );
    }
}
