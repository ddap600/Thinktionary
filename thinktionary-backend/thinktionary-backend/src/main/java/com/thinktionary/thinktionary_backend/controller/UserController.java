package com.thinktionary.thinktionary_backend.controller;

import com.thinktionary.thinktionary_backend.dto.UserCreateRequestDto;
import com.thinktionary.thinktionary_backend.dto.UserResponseDto;
import com.thinktionary.thinktionary_backend.dto.UserUpdateRequestDto;
import com.thinktionary.thinktionary_backend.service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@AllArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    /// Get All Users
    @GetMapping
    public ResponseEntity<List<UserResponseDto>> getAllUsers() {
        List<UserResponseDto> response = userService.getAllUsers();
        return ResponseEntity.ok(response);
    }

    /// Get User by Id
    @GetMapping("{id}")
    public ResponseEntity<UserResponseDto> getUserById(@PathVariable("id") Long id) {
        UserResponseDto response = userService.getUserById(id);
        return ResponseEntity.ok(response);
    }

    /// Create User
    @PostMapping
    public ResponseEntity<UserResponseDto> createUser(
            @Valid @RequestBody UserCreateRequestDto userCreateRequestDto) {
        UserResponseDto response = userService.createUser(userCreateRequestDto);
        return ResponseEntity.ok(response);
    }

    /// Update User
    @PutMapping("{id}")
    public ResponseEntity<UserResponseDto> updateUser(
            @RequestBody UserUpdateRequestDto userUpdateRequestDto,
            @PathVariable("id") Long id
    ) {
        UserResponseDto response = userService.updateUser(userUpdateRequestDto, id);
        return ResponseEntity.ok(response);
    }

    /// Delete User
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long id) {
        String response = userService.deleteUser(id);
        return ResponseEntity.ok(response);
    }
}
