package org.sopt.demo.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.sopt.demo.common.dto.ApiResponse;
import org.sopt.demo.controller.dto.request.BlogTitleUpdateRequest;
import org.sopt.demo.exception.SuccessMessage;
import org.sopt.demo.service.BlogService;
import org.sopt.demo.controller.dto.request.BlogCreateRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1")
@RequiredArgsConstructor
public class BlogController {

    private final BlogService blogService;

    @PostMapping("/blog")
    public ResponseEntity<ApiResponse> createBlog(
            @RequestHeader Long memberId,
            @RequestBody BlogCreateRequest blogCreateRequest
    ) {
        return ResponseEntity.status(HttpStatus.CREATED).header(
                "Location",
                blogService.createBlog(memberId, blogCreateRequest))
                .body(ApiResponse.success(SuccessMessage.BLOG_CREATE_SUCCESS));
    }

    @PatchMapping("/blog/{blogId}/title")
    public ResponseEntity<ApiResponse> updateBlogTitle(
            @PathVariable Long blogId,
            @Valid @RequestBody BlogTitleUpdateRequest blogTitleUpdateRequest
    ) {
        blogService.updateTitle(blogId, blogTitleUpdateRequest);
        return ResponseEntity.noContent().build();
    }
}
