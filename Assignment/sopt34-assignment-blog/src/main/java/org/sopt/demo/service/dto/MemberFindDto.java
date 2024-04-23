package org.sopt.demo.service.dto;

import org.sopt.demo.domain.Member;
import org.sopt.demo.domain.Part;

public record MemberFindDto(
        String name,
        Part part,
        int age
) {
    public static MemberFindDto of(
            Member member
    ) {
        return new MemberFindDto(member.getName(), member.getPart(), member.getAge());
    }
}
