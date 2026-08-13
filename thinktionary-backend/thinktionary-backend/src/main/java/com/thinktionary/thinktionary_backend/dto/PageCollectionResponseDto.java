package com.thinktionary.thinktionary_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PageCollectionResponseDto {

    private Long id;
    private String name;
    private Instant createdAt;
    private Instant updatedAt;
}
