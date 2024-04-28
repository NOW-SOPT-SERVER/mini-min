package org.sopt.demo.service.dto.response;

import org.sopt.demo.domain.Member;
import org.sopt.demo.domain.enums.Part;

public record MemberFindResponse(
        String name,
        Part part,
        int age
) {
    public static MemberFindResponse of(
            Member member
    ) {
        return new MemberFindResponse(member.getName(), member.getPart(), member.getAge());
    }
}
