package com.thinktionary.thinktionary_backend.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PageComponentCreateRequestDto {

    // TODO: Might change based on frontend

    private String name;
    private String type;
    private String content;
    private Integer position;
    private Integer columnIndex;
}
