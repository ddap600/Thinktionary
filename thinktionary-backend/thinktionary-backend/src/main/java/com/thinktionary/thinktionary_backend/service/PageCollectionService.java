package com.thinktionary.thinktionary_backend.service;

import com.thinktionary.thinktionary_backend.dto.PageCollectionCreateRequestDto;
import com.thinktionary.thinktionary_backend.dto.PageCollectionResponseDto;
import com.thinktionary.thinktionary_backend.dto.PageCollectionUpdateRequestDto;
import com.thinktionary.thinktionary_backend.entity.PageCollection;
import com.thinktionary.thinktionary_backend.exception.ResourceNotFoundException;
import com.thinktionary.thinktionary_backend.mapper.PageCollectionMapper;
import com.thinktionary.thinktionary_backend.repository.PageCollectionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PageCollectionService {

    private final PageCollectionRepository pageCollectionRepository;

    // TODO: This is not the final version, this will need changes

    /// Get All PageCollections
    public List<PageCollectionResponseDto> getAllPageCollections() {

        List<PageCollection> pageCollections = pageCollectionRepository.findAll();

        List<PageCollectionResponseDto> pageCollectionResponseDtos = pageCollections.stream()
                .map(PageCollectionMapper::mapPageCollectionToPageCollectionResponseDto)
                .toList();

        return pageCollectionResponseDtos;
    }

    /// Get PageCollection By Id
    public PageCollectionResponseDto getPageCollectionById(Long id) {

        PageCollection pageCollection = pageCollectionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Page Collection Not Found"));

        PageCollectionResponseDto pageCollectionResponseDto = PageCollectionMapper
                .mapPageCollectionToPageCollectionResponseDto(pageCollection);

        return pageCollectionResponseDto;
    }

    /// Create Page Collection
    public PageCollectionResponseDto createPageCollection(PageCollectionCreateRequestDto pageCollectionCreateRequestDto) {

        PageCollection pageCollection = pageCollectionRepository.save(PageCollectionMapper
                .mapPageCollectionCreateRequestToPageCollection(pageCollectionCreateRequestDto));

        return PageCollectionMapper
                .mapPageCollectionToPageCollectionResponseDto(pageCollection);

    }

    /// Update Page Collection
    public PageCollectionResponseDto updatePageCollection(
            Long id,
            PageCollectionUpdateRequestDto pageCollectionUpdateRequestDto) {

        PageCollection existingPageCollection = pageCollectionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Page Collection Not Found"));

        PageCollectionMapper.mapPageCollectionUpdateRequestToPageCollection(
                pageCollectionUpdateRequestDto, existingPageCollection);

        PageCollection updatedCollection = pageCollectionRepository.save(existingPageCollection);
        PageCollectionResponseDto pageCollectionResponseDto = PageCollectionMapper
                .mapPageCollectionToPageCollectionResponseDto(updatedCollection);

        return pageCollectionResponseDto;
    }

    /// Delete Page Collection
    public void deletePageCollection(Long id) {

        pageCollectionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Page Collection Not Found"));

        pageCollectionRepository.deleteById(id);
    }
}
