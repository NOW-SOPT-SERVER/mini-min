package org.sopt.demo.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.sopt.demo.service.dto.MemberCreateDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Tag(name = "멤버", description = "[MemberController] 멤버 관련 API 입니다.")
public interface MemberControllerSwagger {

    @Operation(summary = "멤버 생성 API")
    ResponseEntity createMember(@RequestBody MemberCreateDto memberCreate);

    @Operation(summary = "멤버 조회 API")
    ResponseEntity findMemberById(@PathVariable Long memberId);

    @Operation(summary = "전체 멤버 조회 API")
    ResponseEntity findAllMembers();

    @Operation(summary = "멤버 삭제 API")
    ResponseEntity deleteMemberById(@PathVariable Long memberId);

}
