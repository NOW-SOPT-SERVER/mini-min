package org.sopt.demo.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.sopt.demo.service.MemberService;
import org.sopt.demo.service.dto.MemberCreateDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@Tag(name = "멤버", description = "멤버 관련 API 입니다. (MemberController)")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/member")
public class MemberController {
    private final MemberService memberService;

    @PostMapping
    @Operation(summary = "멤버 생성 API")
    public ResponseEntity createMember(
            @RequestBody MemberCreateDto memberCreate
    ) {
        return ResponseEntity.created(URI.create(memberService.createMember(memberCreate))).build();
    }

    @GetMapping("/{memberId}")
    @Operation(summary = "멤버 조회 API")
    public ResponseEntity findMemberById(
            @PathVariable Long memberId
    ) {
        return ResponseEntity.ok(memberService.findMemberById(memberId));
    }

    @GetMapping("/all")
    @Operation(summary = "전체 멤버 조회 API")
    public ResponseEntity findAllMembers() {
        return ResponseEntity.ok(memberService.findAllMembers());
    }

    @DeleteMapping("/{memberId}")
    @Operation(summary = "멤버 삭제 API")
    public ResponseEntity deleteMemberById(
            @PathVariable Long memberId
    ) {
        memberService.deleteMemberById(memberId);
        return ResponseEntity.noContent().build();
    }
}
