package org.sopt.demo.controller;

import lombok.RequiredArgsConstructor;
import org.sopt.demo.service.MemberService;
import org.sopt.demo.service.dto.MemberCreateDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/member")
public class MemberController implements MemberControllerSwagger {
    private final MemberService memberService;

    @Override
    @PostMapping
    public ResponseEntity createMember(
            @RequestBody MemberCreateDto memberCreate
    ) {
        return ResponseEntity.created(URI.create(memberService.createMember(memberCreate))).build();
    }

    @Override
    @GetMapping("/{memberId}")
    public ResponseEntity findMemberById(
            @PathVariable Long memberId
    ) {
        return ResponseEntity.ok(memberService.findMemberById(memberId));
    }

    @Override
    @GetMapping("/all")
    public ResponseEntity findAllMembers() {
        return ResponseEntity.ok(memberService.findAllMembers());
    }

    @Override
    @DeleteMapping("/{memberId}")
    public ResponseEntity deleteMemberById(
            @PathVariable Long memberId
    ) {
        memberService.deleteMemberById(memberId);
        return ResponseEntity.noContent().build();
    }
}
