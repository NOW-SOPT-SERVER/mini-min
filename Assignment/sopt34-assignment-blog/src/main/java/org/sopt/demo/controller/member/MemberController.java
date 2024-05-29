package org.sopt.demo.controller.member;

import lombok.RequiredArgsConstructor;
import org.sopt.demo.service.MemberService;
import org.sopt.demo.service.dto.request.MemberCreateRequest;
import org.sopt.demo.service.dto.response.RefreshAccessTokenResponse;
import org.sopt.demo.service.dto.response.UserJoinResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class MemberController implements MemberControllerSwagger {
    private final MemberService memberService;

    @Override
    @PostMapping("/member")
    public ResponseEntity<UserJoinResponse> createMember(
            @RequestBody MemberCreateRequest memberCreate
    ) {
        UserJoinResponse userJoinResponse = memberService.createMember(memberCreate);
        return ResponseEntity.status(HttpStatus.CREATED)
                .header("Location", userJoinResponse.userId())
                .body(
                        userJoinResponse
                );
    }

    @Override
    @GetMapping("/member/{memberId}")
    public ResponseEntity findMemberById(
            @PathVariable Long memberId
    ) {
        return ResponseEntity.ok(memberService.findMemberById(memberId));
    }

    @Override
    @GetMapping("/member/all")
    public ResponseEntity findAllMembers() {
        return ResponseEntity.ok(memberService.findAllMembers());
    }

    @Override
    @DeleteMapping("/member/{memberId}")
    public ResponseEntity deleteMemberById(
            @PathVariable Long memberId
    ) {
        memberService.deleteMemberById(memberId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/refresh-token")
    public ResponseEntity<RefreshAccessTokenResponse> refreshAccessToken(
            @RequestHeader String refreshToken
    ) {
        return ResponseEntity.ok(memberService.getAccessToken(refreshToken));
    }
}
