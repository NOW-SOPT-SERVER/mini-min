package org.sopt.demo.service.dto;

import org.sopt.demo.domain.Member;
import org.sopt.demo.domain.Part;

public record MemberFindDto(
        String name,
        Part part,
        int age
) {
    // 정적 팩토리 메서드로 객체를 생성
    public static MemberFindDto of(
            Member member
    ) {
        return new MemberFindDto(member.getName(), member.getPart(), member.getAge());
    }
}
