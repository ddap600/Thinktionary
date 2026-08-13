package com.thinktionary.thinktionary_backend.mapper;

import com.thinktionary.thinktionary_backend.dto.PageComponentCreateRequestDto;
import com.thinktionary.thinktionary_backend.dto.PageComponentResponseDto;
import com.thinktionary.thinktionary_backend.dto.PageComponentUpdateRequestDto;
import com.thinktionary.thinktionary_backend.entity.Page;
import com.thinktionary.thinktionary_backend.entity.PageComponent;

public class PageComponentMapper {

    public static PageComponentResponseDto mapPageComponentToPageComponentResponseDto(
            PageComponent pageComponent
    ) {

        return new PageComponentResponseDto(
                pageComponent.getId(),
                pageComponent.getName(),
                pageComponent.getType(),
                pageComponent.getContent(),
                pageComponent.getPosition(),
                pageComponent.getColumnIndex()
        );
    }

    public static PageComponent mapPageComponentCreateRequestToPage(PageComponentCreateRequestDto pageComponentCreateRequestDto) {

        return new PageComponent(
                pageComponentCreateRequestDto.getName(),
                pageComponentCreateRequestDto.getType(),
                pageComponentCreateRequestDto.getContent(),
                pageComponentCreateRequestDto.getPosition(),
                pageComponentCreateRequestDto.getColumnIndex()
        );
    }

    public static void mapPageComponentUpdateRequestToPage(
            PageComponentUpdateRequestDto pageComponentUpdateRequestDto,
            PageComponent pageComponent) {

        pageComponent.setName(pageComponentUpdateRequestDto.getName());
        pageComponent.setType(pageComponentUpdateRequestDto.getType());
        pageComponent.setContent(pageComponentUpdateRequestDto.getContent());
        pageComponent.setPosition(pageComponentUpdateRequestDto.getPosition());
        pageComponent.setColumnIndex(pageComponentUpdateRequestDto.getColumnIndex());

    }
}
