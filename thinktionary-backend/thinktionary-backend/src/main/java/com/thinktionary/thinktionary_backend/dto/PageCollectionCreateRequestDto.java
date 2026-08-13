package com.thinktionary.thinktionary_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PageCollectionCreateRequestDto {

    private String name;
    private String description;

}
