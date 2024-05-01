package org.sopt.demo.controller.post;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.sopt.demo.common.dto.ResponseDto;
import org.sopt.demo.service.dto.request.BlogPostCreateRequest;
import org.sopt.demo.service.dto.response.PostFindResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@Tag(name = "글", description = "[PostController] 블로그 글 관련 API 입니다.")
public interface PostControllerSwagger {
    @Operation(summary = "글 작성 API")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "블로그 글 작성이 완료되었습니다"),
            @ApiResponse(responseCode = "403", description = "해당 사용자는 해당 블로그에 대한 접근 권한(글 작성, 수정, 삭제)이 없습니다"),
            @ApiResponse(responseCode = "404", description = "해당 블로그가 존재하지 않습니다")
    })
    ResponseEntity createBlogPost(
            @RequestHeader Long memberId,
            @RequestHeader Long blogId,
            @Valid @RequestBody BlogPostCreateRequest blogPostCreateRequest
    );

    @Operation(summary = "글 조회 API")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "블로그 글 조회에 성공했습니다"),
            @ApiResponse(responseCode = "404", description = "존재하지 않는 블로그 글을 조회하고 있습니다",
                    content = @Content(schema = @Schema(implementation = ResponseDto.class)))
    })
    ResponseEntity<ResponseDto<PostFindResponse>> findPostById(
            @PathVariable Long postId
    );
}
