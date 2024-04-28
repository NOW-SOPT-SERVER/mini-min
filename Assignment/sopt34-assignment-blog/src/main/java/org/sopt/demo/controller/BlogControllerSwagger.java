package org.sopt.demo.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.sopt.demo.common.dto.ApiResponse;
import org.sopt.demo.controller.dto.request.BlogCreateRequest;
import org.sopt.demo.controller.dto.request.BlogTitleUpdateRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@Tag(name = "블로그", description = "[BlogController] 블로그 관련 API 입니다.")
public interface BlogControllerSwagger {

    @Operation(summary = "블로그 생성 API")
    ResponseEntity<ApiResponse> createBlog(
            @RequestHeader Long memberId,
            @RequestBody BlogCreateRequest blogCreateRequest
    );

    @Operation(summary = "블로그 이름 수정 API")
    ResponseEntity<ApiResponse> updateBlogTitle(
            @PathVariable Long blogId,
            @Valid @RequestBody BlogTitleUpdateRequest blogTitleUpdateRequest
    );
}
