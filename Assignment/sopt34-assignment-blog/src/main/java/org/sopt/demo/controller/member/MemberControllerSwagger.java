package org.sopt.demo.controller.member;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.sopt.demo.service.dto.response.AllMembersListResponse;
import org.sopt.demo.service.dto.request.MemberCreateRequest;
import org.sopt.demo.service.dto.response.MemberFindResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Tag(name = "멤버", description = "[MemberController] 멤버 관련 API 입니다.")
public interface MemberControllerSwagger {

    @Operation(summary = "멤버 생성 API")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "멤버 가입이 완료되었습니다")
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
                                    schema = @Schema(implementation = AllMembersListResponse.class))),
            }
    )
    ResponseEntity findAllMembers();

    @Operation(summary = "멤버 삭제 API")
    ResponseEntity deleteMemberById(@PathVariable Long memberId);

}
