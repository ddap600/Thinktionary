package com.thinktionary.thinktionary_backend.controller;

import com.thinktionary.thinktionary_backend.dto.PageCollectionCreateRequestDto;
import com.thinktionary.thinktionary_backend.dto.PageCollectionResponseDto;
import com.thinktionary.thinktionary_backend.dto.PageCollectionUpdateRequestDto;
import com.thinktionary.thinktionary_backend.service.PageCollectionService;
import lombok.AllArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(
        origins = "http://localhost:5173",
        allowCredentials = "true"
)
@AllArgsConstructor
@RestController
@RequestMapping("/collection")
public class PageCollectionController {

    private final PageCollectionService pageCollectionService;

    /// Get All Page Collections By Owner Id
    @GetMapping("/mine")
    public ResponseEntity<List<PageCollectionResponseDto>> getAllPageCollectionsByOwnerId(
            Authentication authentication
    ) {
        // TODO : REMOVE
        System.out.println("REACHED CONTROLLER");
        System.out.println("AUTHENTICATION " + authentication.toString());

        List<PageCollectionResponseDto> pageCollectionResponseDtos = pageCollectionService.getAllPageCollectionsByOwner(authentication);
        return ResponseEntity.ok(pageCollectionResponseDtos);
    }

    /// Get All Page Collections
    @GetMapping
    public ResponseEntity<List<PageCollectionResponseDto>> getAllPageCollections() {
        List<PageCollectionResponseDto> pageCollectionResponseDtos = pageCollectionService.getAllPageCollections();
        return ResponseEntity.ok(pageCollectionResponseDtos);
    }

    /// Get Page Collection By Id
    @GetMapping("{id}")
    public ResponseEntity<PageCollectionResponseDto> getPageCollectionById(@PathVariable("id") Long id) {
        PageCollectionResponseDto pageCollectionResponseDto = pageCollectionService.getPageCollectionById(id);
        return ResponseEntity.ok(pageCollectionResponseDto);
    }

    /// Create Page Collection
    @PostMapping
    public ResponseEntity<PageCollectionResponseDto> createPageCollection(
            @RequestBody PageCollectionCreateRequestDto pageCollectionCreateRequestDto) {
        PageCollectionResponseDto pageCollectionResponseDto = pageCollectionService
                .createPageCollection(pageCollectionCreateRequestDto);
        return ResponseEntity.ok(pageCollectionResponseDto);
    }

    /// Update Page Collection
    @PutMapping("{id}")
    public ResponseEntity<PageCollectionResponseDto> updatePageCollection(
            @PathVariable("id") Long id,
            @RequestBody PageCollectionUpdateRequestDto pageCollectionUpdateRequestDto
    ) {
        PageCollectionResponseDto pageCollectionResponseDto = pageCollectionService
                .updatePageCollection(id, pageCollectionUpdateRequestDto);
        return ResponseEntity.ok(pageCollectionResponseDto);
    }

    /// Delete Page Collection
    @DeleteMapping("{id}")
    public ResponseEntity<String> deletePageCollection(
            @PathVariable("id") Long id
    ) {
        pageCollectionService.deletePageCollection(id);
        return ResponseEntity.ok("Deleted Successfully");
    }
}
