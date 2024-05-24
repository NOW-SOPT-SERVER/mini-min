package org.sopt.demo.controller.blog;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.sopt.demo.common.dto.ResponseDto;
import org.sopt.demo.service.dto.request.BlogCreateRequest;
import org.sopt.demo.service.dto.request.BlogTitleUpdateRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Tag(name = "블로그", description = "[BlogController] 블로그 관련 API 입니다.")
public interface BlogControllerSwagger {

    @Operation(summary = "블로그 생성 API")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "블로그 생성이 완료되었습니다"),
            @ApiResponse(responseCode = "404", description = "ID에 해당하는 사용자가 존재하지 않습니다")
    })
    ResponseEntity<ResponseDto> createBlog(
            @RequestBody BlogCreateRequest blogCreateRequest
    );

    @Operation(summary = "블로그 이름 수정 API")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "블로그 이름 수정이 완료되었습니다"),
            @ApiResponse(responseCode = "400", description = "블로그 제목이 최대 글자 수(10자)를 초과했습니다."),
            @ApiResponse(responseCode = "404", description = "해당 블로그가 존재하지 않습니다")
    })
    ResponseEntity<ResponseDto> updateBlogTitle(
            @PathVariable Long blogId,
            @Valid @RequestBody BlogTitleUpdateRequest blogTitleUpdateRequest
    );
}
