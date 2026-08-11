package com.thinktionary.thinktionary_backend.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserCreateRequestDto {

    @NotBlank
    private String displayName;

    @NotBlank
    private String username;

    @NotBlank
    private String password;
}
