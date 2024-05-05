package org.sopt.demo.service.dto.response;

import org.sopt.demo.domain.Member;

import java.util.List;

public record AllMembersResponse(
        List<Member> members
) {
    public static AllMembersResponse of(List<Member> members) {
        return new AllMembersResponse(members);
    }
}
