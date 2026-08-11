package com.thinktionary.thinktionary_backend.controller;

import com.thinktionary.thinktionary_backend.dto.AuthLoginRequestDto;
import com.thinktionary.thinktionary_backend.dto.AuthResponseDto;
import com.thinktionary.thinktionary_backend.service.AuthService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@AllArgsConstructor
@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    /// Login User
    @PostMapping("/login")
    public ResponseEntity<AuthResponseDto> loginUser(@Valid @RequestBody AuthLoginRequestDto authLoginRequestDto) {
        AuthResponseDto authResponseDto = authService.loginUser(authLoginRequestDto);
        return ResponseEntity.ok(authResponseDto);
    }

    @GetMapping("/token-test")
    public ResponseEntity<String> testToken(Authentication authentication) {
        return ResponseEntity.ok("Success: " + authentication.getName());
    }
}
