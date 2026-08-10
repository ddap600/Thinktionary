package com.thinktionary.thinktionary_backend.mapper;

import com.thinktionary.thinktionary_backend.dto.PageCreateRequestDto;
import com.thinktionary.thinktionary_backend.dto.PageResponseDto;
import com.thinktionary.thinktionary_backend.dto.PageUpdateRequestDto;
import com.thinktionary.thinktionary_backend.entity.Page;

public class PageMapper {

    public static Page mapPageCreateDtoToPage(
            PageCreateRequestDto pageCreateRequestDto) {

        return new Page(
                pageCreateRequestDto.getTitle(),
                pageCreateRequestDto.getContent()
        );
    }

    public static void mapPageUpdateDtoToPage(
            PageUpdateRequestDto pageUpdateRequestDto,
            Page page) {

        page.setTitle(pageUpdateRequestDto.getTitle());
        page.setContent(pageUpdateRequestDto.getContent());
    }

    public static PageResponseDto mapPageToPageResponseDto(
            Page page) {

        return new PageResponseDto(
                page.getId(),
                page.getTitle(),
                page.getContent()
        );
    }
}
