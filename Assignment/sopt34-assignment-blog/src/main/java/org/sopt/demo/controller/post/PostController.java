package org.sopt.demo.controller.post;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.sopt.demo.common.dto.ApiResponse;
import org.sopt.demo.exception.SuccessMessage;
import org.sopt.demo.service.BlogService;
import org.sopt.demo.service.PostService;
import org.sopt.demo.service.dto.request.BlogPostCreateRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class PostController implements PostControllerSwagger {

    private final PostService postService;

    @PostMapping("/post")
    public ResponseEntity<ApiResponse> createBlogPost(
            @RequestHeader Long memberId,
            @RequestHeader Long blogId,
            @Valid @RequestBody BlogPostCreateRequest blogPostCreateRequest
    ) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .header("Location", postService.createBlogPost(memberId, blogId, blogPostCreateRequest))
                .body(ApiResponse.success(SuccessMessage.BLOG_POST_CREATE_SUCCESS));
    }

    @GetMapping("/post/{postId}")
    public ResponseEntity<ApiResponse> findPostById(
            @PathVariable Long postId
    ) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(ApiResponse.success(SuccessMessage.GET_POST_SUCCESS, postService.findPostById(postId)));
    }
}
