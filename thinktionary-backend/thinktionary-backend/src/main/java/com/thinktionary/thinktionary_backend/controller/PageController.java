package com.thinktionary.thinktionary_backend.controller;

import com.thinktionary.thinktionary_backend.dto.PageCreateRequestDto;
import com.thinktionary.thinktionary_backend.dto.PageResponseDto;
import com.thinktionary.thinktionary_backend.dto.PageUpdateRequestDto;
import com.thinktionary.thinktionary_backend.service.PageService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@AllArgsConstructor
@RestController
@RequestMapping("/page")
public class PageController {

    private final PageService pageService;

    /// Get All Pages
    @GetMapping
    public ResponseEntity<List<PageResponseDto>> getAllPages() {
        List<PageResponseDto> pages = pageService.getAllPages();
        return ResponseEntity.ok(pages);
    }

    /// Get Page By Id
    @GetMapping("{id}")
    public ResponseEntity<PageResponseDto> getPageById(@PathVariable("id") Long id) {
        PageResponseDto pageResponseDto = pageService.getPageById(id);
        return ResponseEntity.ok(pageResponseDto);
    }

    /// Create Page
    @PostMapping
    public ResponseEntity<PageResponseDto> createPage(@Valid @RequestBody PageCreateRequestDto pageCreateRequestDto) {
        PageResponseDto pageResponseDto = pageService.createPage(pageCreateRequestDto);
        return ResponseEntity.ok(pageResponseDto);
    }

    /// Update Page
    @PutMapping("{id}")
    public ResponseEntity<PageResponseDto> updatePage(
            @PathVariable("id") Long id,
            @Valid @RequestBody PageUpdateRequestDto pageUpdateRequestDto) {
        PageResponseDto pageResponseDto = pageService.updatePage(id, pageUpdateRequestDto);
        return ResponseEntity.ok(pageResponseDto);
    }

    /// Delete Page
    @DeleteMapping("{id}")
    public ResponseEntity<String> deletePage(@PathVariable("id") Long id) {
        pageService.deletePage(id);
        return ResponseEntity.ok("Deleted page successfully");
    }

}
