package org.sopt.demo.controller.member;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.sopt.demo.common.dto.ResponseDto;
import org.sopt.demo.service.dto.response.AllMembersResponse;
import org.sopt.demo.service.dto.request.MemberCreateRequest;
import org.sopt.demo.service.dto.response.MemberFindResponse;
import org.sopt.demo.service.dto.response.RefreshAccessTokenResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@Tag(name = "멤버", description = "[MemberController] 멤버 관련 API 입니다.")
public interface MemberControllerSwagger {

    @Operation(summary = "멤버 생성 API")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "멤버 가입이 완료되었습니다"),
            @ApiResponse(responseCode = "401", description = "사용자의 로그인 검증을 실패했습니다.", content = @Content(schema = @Schema(implementation = ResponseDto.class)))
    })
    ResponseEntity createMember(@RequestBody MemberCreateRequest memberCreate);

    @Operation(summary = "멤버 조회 API")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    content = @Content(schema = @Schema(implementation = MemberFindResponse.class)))
            }
    )
    ResponseEntity findMemberById(@PathVariable Long memberId);

    @Operation(summary = "전체 멤버 조회 API")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = AllMembersResponse.class))),
            }
    )
    ResponseEntity findAllMembers();

    @Operation(summary = "멤버 삭제 API")
    ResponseEntity deleteMemberById(@PathVariable Long memberId);

    @Operation(summary = "AccessToken 재발급 API")
    ResponseEntity<RefreshAccessTokenResponse> refreshAccessToken(@RequestHeader String refreshToken);
}
