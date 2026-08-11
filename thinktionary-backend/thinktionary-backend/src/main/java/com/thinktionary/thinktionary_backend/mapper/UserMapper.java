package com.thinktionary.thinktionary_backend.mapper;

import com.thinktionary.thinktionary_backend.dto.UserCreateRequestDto;
import com.thinktionary.thinktionary_backend.dto.UserResponseDto;
import com.thinktionary.thinktionary_backend.dto.UserUpdateRequestDto;
import com.thinktionary.thinktionary_backend.entity.Role;
import com.thinktionary.thinktionary_backend.entity.User;

import java.util.stream.Collectors;

public class UserMapper {

    public static User mapUserCreateRequestDtoToUser(UserCreateRequestDto userCreateRequestDto) {

        return new User(
                userCreateRequestDto.getDisplayName(),
                userCreateRequestDto.getUsername(),
                userCreateRequestDto.getPassword()
        );
    }

    public static void mapUserUpdateRequestDtoToUser(UserUpdateRequestDto userUpdateRequestDto, User user) {

        user.setDisplayName(userUpdateRequestDto.getDisplayName());
        user.setUsername(userUpdateRequestDto.getUsername());
    }

    public static UserResponseDto mapUserToUserResponseDto(User user) {

        return new UserResponseDto(
                user.getId(),
                user.getDisplayName(),
                user.getUsername(),
                user.getRoles()
                        .stream()
                        .map(Role::getName)
                        .collect(Collectors.toSet())

        );
    }

}
