package org.sopt.demo.controller.blog;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.sopt.demo.auth.PrincipalHandler;
import org.sopt.demo.common.ResponseDto;
import org.sopt.demo.service.dto.request.BlogTitleUpdateRequest;
import org.sopt.demo.exception.SuccessMessage;
import org.sopt.demo.service.BlogService;
import org.sopt.demo.service.dto.request.BlogCreateRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class BlogController implements BlogControllerSwagger {

    private final BlogService blogService;
    private final PrincipalHandler principalHandler;

    @Override
    @PostMapping("/blog")
    public ResponseEntity<ResponseDto> createBlog(
            @RequestBody BlogCreateRequest blogCreateRequest
    ) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .header("Location", blogService.createBlog(
                        principalHandler.getUserIdFromPrincipal(),
                        blogCreateRequest
                ))
                .body(ResponseDto.success(SuccessMessage.BLOG_CREATE_SUCCESS));
    }

    @Override
    @PatchMapping("/blog/{blogId}/title")
    public ResponseEntity<ResponseDto> updateBlogTitle(
            @PathVariable Long blogId,
            @Valid @RequestBody BlogTitleUpdateRequest blogTitleUpdateRequest
    ) {
        blogService.updateTitle(blogId, blogTitleUpdateRequest);
        return ResponseEntity.status(HttpStatus.NO_CONTENT)
                .body(ResponseDto.success(SuccessMessage.BLOG_NAME_PATCH_SUCCESS));
    }
}
