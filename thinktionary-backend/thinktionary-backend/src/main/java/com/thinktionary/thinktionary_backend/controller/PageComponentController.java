package com.thinktionary.thinktionary_backend.controller;

import com.thinktionary.thinktionary_backend.dto.PageComponentCreateRequestDto;
import com.thinktionary.thinktionary_backend.dto.PageComponentResponseDto;
import com.thinktionary.thinktionary_backend.dto.PageComponentUpdateRequestDto;
import com.thinktionary.thinktionary_backend.service.PageComponentService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@AllArgsConstructor
@RestController
@RequestMapping("/component")
public class PageComponentController {

    private final PageComponentService pageComponentService;

    /// Get All Page Components
    @GetMapping
    public ResponseEntity<List<PageComponentResponseDto>> getAllPageComponents() {
        List<PageComponentResponseDto> pageComponentResponseDtos = pageComponentService
                .getAllPageComponents();
        return ResponseEntity.ok(pageComponentResponseDtos);
    }

    /// Get Page Component By Id
    @GetMapping("{id}")
    public ResponseEntity<PageComponentResponseDto> getPageComponentById(
            @PathVariable Long id) {
        PageComponentResponseDto pageComponentResponseDto = pageComponentService
                .getPageComponentById(id);
        return ResponseEntity.ok(pageComponentResponseDto);
    }

    /// Create Page Component
    @PostMapping
    public ResponseEntity<PageComponentResponseDto> createPageComponent(
            @RequestBody PageComponentCreateRequestDto pageComponentCreateRequestDto) {
        PageComponentResponseDto pageComponentResponseDto = pageComponentService
                .createPageComponent(pageComponentCreateRequestDto);
        return ResponseEntity.ok(pageComponentResponseDto);
    }

    /// Update Page Component
    @PutMapping("{id}")
    public ResponseEntity<PageComponentResponseDto> updatePageComponent(
            @PathVariable("id") Long id,
            @RequestBody PageComponentUpdateRequestDto pageComponentUpdateRequestDto
    ) {
        PageComponentResponseDto pageComponentResponseDto = pageComponentService
                .updatePageComponent(id, pageComponentUpdateRequestDto);
        return ResponseEntity.ok(pageComponentResponseDto);
    }


    /// Delete Page Component
    @DeleteMapping("{id}")
    public ResponseEntity<String> deletePageComponent(
            @PathVariable("id") Long id
    ) {
        pageComponentService.deletePageComponent(id);
        return ResponseEntity.ok("Deleted successfully");
    }
}
