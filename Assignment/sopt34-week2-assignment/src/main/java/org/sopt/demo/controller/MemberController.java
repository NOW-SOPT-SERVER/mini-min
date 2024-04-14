package org.sopt.demo.controller;

import lombok.RequiredArgsConstructor;
import org.sopt.demo.service.MemberService;
import org.sopt.demo.service.dto.MemberCreateDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
// RequiredArgsConstructor : 의존성 주입을 위한 어노테이션
// 불변성을 보장하기 위해 의존성을 주입할 객체는 final 키워드가 있는 인스턴스만 Bean으로 등록한다
@RequiredArgsConstructor
// RequestMapping : 클라이언트에게 받은 요청을 특정 메서드와 매핑하기 위해 사용하는 것
// value: 요청받을 URI를 설정
// method: 어떤 요청으로 받을지 정의 (method = RequestMethod.GET와 같이 파라미터를 추가할 수 있다.)
@RequestMapping("/api/v1/member")
public class MemberController {
    private final MemberService memberService;

    @PostMapping    // 위에 있는 RequestMapping 어노테이션을 반복해서 사용하지 않기 위해 이렇게 표시
    public ResponseEntity createMember(
            @RequestBody MemberCreateDto memberCreate   // RequestBody를 통해 JSON 형태의 데이터를 자바 객체로 변환해서 받아옴
    ) {
        // HttpEntity : HTTP 요청(Request) 또는 응답(Response)에 해당하는 HttpHeader와 HttpBody를 포함하는 클래스
        // HttpEntity를 상속받아 구현한 클래스가 RequestEntity, ResponseEntity 클래스임
        // ResponseEntity : 사용자의 HttpRequest에 대한 응답 데이터를 포함하는 클래스 (HttpStatus, HttpHeaders, HttpBody 모두 포함)
        return ResponseEntity.created(URI.create(memberService.createMember(memberCreate))).build();
    }

    @GetMapping("/{memberId}")
    public ResponseEntity findMemberById(
            @PathVariable Long memberId
    ) {
        return ResponseEntity.ok(memberService.findMemberById(memberId));
    }

    @GetMapping("/all")
    public ResponseEntity findAllMembers() {
        return ResponseEntity.ok(memberService.findAllMembers());
    }

    @DeleteMapping("/{memberId}")
    public ResponseEntity deleteMemberById(
            @PathVariable Long memberId
    ) {
        memberService.deleteMemberById(memberId);
        return ResponseEntity.noContent().build();
    }
}
