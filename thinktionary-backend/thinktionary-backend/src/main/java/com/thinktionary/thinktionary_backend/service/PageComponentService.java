package com.thinktionary.thinktionary_backend.service;

import com.thinktionary.thinktionary_backend.dto.PageComponentCreateRequestDto;
import com.thinktionary.thinktionary_backend.dto.PageComponentResponseDto;
import com.thinktionary.thinktionary_backend.dto.PageComponentUpdateRequestDto;
import com.thinktionary.thinktionary_backend.entity.PageComponent;
import com.thinktionary.thinktionary_backend.exception.ResourceNotFoundException;
import com.thinktionary.thinktionary_backend.mapper.PageComponentMapper;
import com.thinktionary.thinktionary_backend.repository.PageComponentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PageComponentService {

    // TODO: This is not the final version, this will need changes

    private final PageComponentRepository pageComponentRepository;

    /// View All Page Components
    public List<PageComponentResponseDto> getAllPageComponents() {

        List<PageComponent> pageComponents = pageComponentRepository.findAll();

        List<PageComponentResponseDto> pageComponentResponseDtos = pageComponents
                .stream()
                .map(PageComponentMapper::mapPageComponentToPageComponentResponseDto)
                .toList();

        return pageComponentResponseDtos;
    }

    /// View Page Component By Id
    public PageComponentResponseDto getPageComponentById(Long id) {

        PageComponent pageComponent = pageComponentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Page Component Not Found"));

        return PageComponentMapper.mapPageComponentToPageComponentResponseDto(pageComponent);
    }

    /// Create Page
    public PageComponentResponseDto createPageComponent(PageComponentCreateRequestDto pageComponentCreateRequestDto) {

        PageComponent pageComponent = pageComponentRepository.save(PageComponentMapper
                .mapPageComponentCreateRequestToPage(pageComponentCreateRequestDto));

        return PageComponentMapper.mapPageComponentToPageComponentResponseDto(pageComponent);
    }

    /// Update Page
    public PageComponentResponseDto updatePageComponent(
            Long id, PageComponentUpdateRequestDto pageCollectionUpdateRequestDto) {

        PageComponent existingPageComponent = pageComponentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Page Component Not Found"));

        PageComponentMapper.mapPageComponentUpdateRequestToPage(
                pageCollectionUpdateRequestDto,
                existingPageComponent
        );

        PageComponent updatePageComponent = pageComponentRepository.save(existingPageComponent);

        return PageComponentMapper.mapPageComponentToPageComponentResponseDto(updatePageComponent);
    }

    /// Delete Page Component
    public void deletePageComponent(Long id) {

        pageComponentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Page Component Not Found"));

        pageComponentRepository.deleteById(id);
    }

}
