package com.thinktionary.thinktionary_backend.controller;

import com.thinktionary.thinktionary_backend.dto.PageCollectionCreateRequestDto;
import com.thinktionary.thinktionary_backend.dto.PageCollectionResponseDto;
import com.thinktionary.thinktionary_backend.dto.PageCollectionUpdateRequestDto;
import com.thinktionary.thinktionary_backend.service.PageCollectionService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@AllArgsConstructor
@RestController
@RequestMapping("/collection")
public class PageCollectionController {

    private final PageCollectionService pageCollectionService;

    /// Get All Page Collections
    @GetMapping
    public ResponseEntity<List<PageCollectionResponseDto>> getAllPages() {
        List<PageCollectionResponseDto> pageCollectionResponseDtos = pageCollectionService.getAllPageCollections();
        return ResponseEntity.ok(pageCollectionResponseDtos);
    }

    /// Get Page Collection By Id
    @GetMapping("{id}")
    public ResponseEntity<PageCollectionResponseDto> getPageById(@PathVariable("id") Long id) {
        PageCollectionResponseDto pageCollectionResponseDto = pageCollectionService.getPageCollectionById(id);
        return ResponseEntity.ok(pageCollectionResponseDto);
    }

    /// Create Page Collection
    @PostMapping
    public ResponseEntity<PageCollectionResponseDto> createPage(
            @RequestBody PageCollectionCreateRequestDto pageCollectionCreateRequestDto) {
        PageCollectionResponseDto pageCollectionResponseDto = pageCollectionService
                .createPageCollection(pageCollectionCreateRequestDto);
        return ResponseEntity.ok(pageCollectionResponseDto);
    }

    /// Update Page Collection
    @PutMapping("{id}")
    public ResponseEntity<PageCollectionResponseDto> updatePage(
            @PathVariable("id") Long id,
            @RequestBody PageCollectionUpdateRequestDto pageCollectionUpdateRequestDto
    ) {
        PageCollectionResponseDto pageCollectionResponseDto = pageCollectionService
                .updatePageCollection(id, pageCollectionUpdateRequestDto);
        return ResponseEntity.ok(pageCollectionResponseDto);
    }

    /// Delete Page Collection
    @DeleteMapping("{id}")
    public ResponseEntity<String> deletePage(
            @PathVariable("id") Long id
    ) {
        pageCollectionService.deletePageCollection(id);
        return ResponseEntity.ok("Deleted Successfully");
    }
}
