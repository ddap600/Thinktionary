package com.thinktionary.thinktionary_backend.service;

import com.thinktionary.thinktionary_backend.dto.UserCreateRequestDto;
import com.thinktionary.thinktionary_backend.dto.UserResponseDto;
import com.thinktionary.thinktionary_backend.dto.UserUpdateRequestDto;
import com.thinktionary.thinktionary_backend.entity.User;
import com.thinktionary.thinktionary_backend.exception.ResourceNotFoundException;
import com.thinktionary.thinktionary_backend.mapper.UserMapper;
import com.thinktionary.thinktionary_backend.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    /// Get All Users
    public List<UserResponseDto> getAllUsers() {

        List<User> users = userRepository.findAll();

        List<UserResponseDto> userResponseDtos = users
                .stream()
                .map(UserMapper::mapUserToUserResponseDto)
                .toList();

        return userResponseDtos;
    }

    /// Get User By Id
    public UserResponseDto getUserById(Long id) {

        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found!"));

        UserResponseDto userResponseDto = UserMapper.mapUserToUserResponseDto(user);

        return userResponseDto;
    }

    /// Create User
    public UserResponseDto createUser(UserCreateRequestDto userCreateRequestDto) {

        User user = new User(
                userCreateRequestDto.getDisplayName(),
                userCreateRequestDto.getUsername(),
                userCreateRequestDto.getPassword()
                // TODO: Assign the default USER role during registration/auth setup.
        );

        User savedUser = userRepository.save(user);

        UserResponseDto userResponseDto = UserMapper.mapUserToUserResponseDto(savedUser);

        return userResponseDto;
    }

    /// Update User
    public UserResponseDto updateUser(UserUpdateRequestDto userUpdateRequestDto, Long id) {

        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found!"));

        existingUser.setDisplayName(userUpdateRequestDto.getDisplayName());
        existingUser.setUsername(userUpdateRequestDto.getUsername());

        User updatedUser = userRepository.save(existingUser);

        UserResponseDto userResponseDto = UserMapper.mapUserToUserResponseDto(updatedUser);

        return userResponseDto;
    }

    /// Delete User
    public String deleteUser(Long id) {

        userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found!"));

        userRepository.deleteById(id);

        return "User deleted successfully";
    }
}
