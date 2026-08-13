package com.thinktionary.thinktionary_backend.service;

import com.thinktionary.thinktionary_backend.dto.PageCreateRequestDto;
import com.thinktionary.thinktionary_backend.dto.PageResponseDto;
import com.thinktionary.thinktionary_backend.dto.PageUpdateRequestDto;
import com.thinktionary.thinktionary_backend.entity.Page;
import com.thinktionary.thinktionary_backend.exception.ResourceNotFoundException;
import com.thinktionary.thinktionary_backend.mapper.PageMapper;
import com.thinktionary.thinktionary_backend.repository.PageRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PageService {

    private final PageRepository pageRepository;


    ///  Get All Pages
    public List<PageResponseDto> getAllPages() {

        List<Page> pages = pageRepository.findAll();

        List<PageResponseDto> pageResponseDtos = pages.stream()
                .map(PageMapper::mapPageToPageResponseDto)
                .toList();

        return pageResponseDtos;
    }

    /// Get Page By Id
    public PageResponseDto getPageById(Long id) {

        Page page = pageRepository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("Selected page does not exist!"));

        PageResponseDto pageResponseDto = PageMapper.mapPageToPageResponseDto(page);
        return pageResponseDto;
    }

    /// Create Page
    public PageResponseDto createPage(PageCreateRequestDto pageCreateRequestDto) {

        Page page = pageRepository.save(PageMapper.mapPageCreateRequestToPage(pageCreateRequestDto));
        PageResponseDto pageResponseDto = PageMapper.mapPageToPageResponseDto(page);

        return pageResponseDto;
    }

    /// Update Page
    public PageResponseDto updatePage(Long id, PageUpdateRequestDto pageUpdateRequestDto) {

        Page existingPage = pageRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Selected Page does not exist!"));

        PageMapper.mapPageUpdateRequestToPage(pageUpdateRequestDto, existingPage);
        Page updatedPage = pageRepository.save(existingPage);
        PageResponseDto pageResponseDto = PageMapper.mapPageToPageResponseDto(updatedPage);

        return pageResponseDto;
    }

    ///  Delete Page
    public void deletePage(Long id) {

        pageRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Selected Page does not exist!"));

        pageRepository.deleteById(id);
    }
}
