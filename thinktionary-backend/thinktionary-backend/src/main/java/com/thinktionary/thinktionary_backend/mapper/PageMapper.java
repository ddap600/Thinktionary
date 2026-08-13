package com.thinktionary.thinktionary_backend.mapper;

import com.thinktionary.thinktionary_backend.dto.PageCreateRequestDto;
import com.thinktionary.thinktionary_backend.dto.PageResponseDto;
import com.thinktionary.thinktionary_backend.dto.PageUpdateRequestDto;
import com.thinktionary.thinktionary_backend.entity.Page;

public class PageMapper {

    public static Page mapPageCreateRequestToPage(PageCreateRequestDto pageCreateRequestDto) {

        return new Page(pageCreateRequestDto.getTitle(), pageCreateRequestDto.getContent());
    }

    public static void mapPageUpdateRequestToPage(PageUpdateRequestDto pageUpdateRequestDto, Page page) {

        page.setTitle(pageUpdateRequestDto.getTitle());
        page.setContent(pageUpdateRequestDto.getContent());
    }

    // Applies the update DTO's values to an existing entity rather than creating
    // a new entity. This differs from the create mapping above, which constructs
    // a new Page.
    //
    // This is intentional for updates because we want to preserve the existing
    // entity and its relationships. An alternative would be to apply these
    // changes directly in the service layer.
    //
    // TODO (learning): Revisit whether update operations should belong in the
    // mapper or service layer as the application architecture evolves.
    public static PageResponseDto mapPageToPageResponseDto(Page page) {

        return new PageResponseDto(page.getId(), page.getTitle(), page.getContent());
    }
}
