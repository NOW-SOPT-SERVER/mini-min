package org.sopt.demo.controller.post;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.sopt.demo.common.ResponseDto;
import org.sopt.demo.exception.SuccessMessage;
import org.sopt.demo.service.PostService;
import org.sopt.demo.service.dto.request.BlogPostCreateRequest;
import org.sopt.demo.service.dto.response.PostFindResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class PostController implements PostControllerSwagger {

    private final PostService postService;

    @Override
    @PostMapping("/post")
    public ResponseEntity<ResponseDto> createBlogPost(
            @RequestHeader Long memberId,
            @RequestHeader Long blogId,
            @Valid @RequestBody BlogPostCreateRequest blogPostCreateRequest
    ) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .header("Location", postService.createBlogPost(memberId, blogId, blogPostCreateRequest))
                .body(ResponseDto.success(SuccessMessage.BLOG_POST_CREATE_SUCCESS));
    }

    @Override
    @GetMapping("/post/{postId}")
    public ResponseEntity<ResponseDto<PostFindResponse>> findPostById(
            @PathVariable Long postId
    ) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(ResponseDto.success(SuccessMessage.GET_POST_SUCCESS, postService.findPostById(postId)));
    }
}
