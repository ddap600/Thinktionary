package com.thinktionary.thinktionary_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PageComponentResponseDto {

    private Long id;
    private String name;
    private String type;
    private String content;
    private Integer position;
    private Integer columnIndex;
}
