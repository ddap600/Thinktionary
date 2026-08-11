package com.thinktionary.thinktionary_backend.service;

import com.thinktionary.thinktionary_backend.dto.UserCreateRequestDto;
import com.thinktionary.thinktionary_backend.dto.UserResponseDto;
import com.thinktionary.thinktionary_backend.dto.UserUpdateRequestDto;
import com.thinktionary.thinktionary_backend.entity.User;
import com.thinktionary.thinktionary_backend.exception.ResourceNotFoundException;
import com.thinktionary.thinktionary_backend.mapper.UserMapper;
import com.thinktionary.thinktionary_backend.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

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

        // Instead of using the mapper to map the DTO to a new User
        // We do it this way, so that password hashing is in the Service instead of the mapper

        // Using the mapper to create a User object and then encoding it here
        // Would temporarily and briefly create a User object with exposed password

        // Moving the encoder to mapper to avoid this sounds messier than keeping it here

        User user = new User(
                userCreateRequestDto.getDisplayName(),
                userCreateRequestDto.getUsername(),
                passwordEncoder.encode(userCreateRequestDto.getPassword())
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

        UserMapper.mapUserUpdateRequestDtoToUser(
                userUpdateRequestDto,
                existingUser
        );
        
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
