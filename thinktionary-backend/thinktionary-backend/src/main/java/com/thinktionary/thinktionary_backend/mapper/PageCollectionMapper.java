package com.thinktionary.thinktionary_backend.mapper;

import com.thinktionary.thinktionary_backend.dto.PageCollectionCreateRequestDto;
import com.thinktionary.thinktionary_backend.dto.PageCollectionResponseDto;
import com.thinktionary.thinktionary_backend.dto.PageCollectionUpdateRequestDto;
import com.thinktionary.thinktionary_backend.entity.PageCollection;

public class PageCollectionMapper {

    public static PageCollection mapPageCollectionCreateRequestToPageCollection(
            PageCollectionCreateRequestDto pageCollectionCreateRequestDto
    ) {

        return new PageCollection(
                pageCollectionCreateRequestDto.getName(),
                pageCollectionCreateRequestDto.getDescription()
                );
    }

    public static void mapPageCollectionUpdateRequestToPageCollection(
            PageCollectionUpdateRequestDto pageCollectionUpdateRequestDto,
            PageCollection pageCollection
    ) {

        pageCollection.setName(pageCollectionUpdateRequestDto.getName());
        pageCollection.setDescription(pageCollectionUpdateRequestDto.getDescription());
    }

    public static PageCollectionResponseDto mapPageCollectionToPageCollectionResponseDto(
            PageCollection pageCollection
    ) {

        return new PageCollectionResponseDto(
                pageCollection.getId(),
                pageCollection.getName(),
                pageCollection.getCreatedAt(),
                pageCollection.getUpdatedAt()
        );
    }

}
