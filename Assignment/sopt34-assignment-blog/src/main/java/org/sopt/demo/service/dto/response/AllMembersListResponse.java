package org.sopt.demo.service.dto.response;

import org.sopt.demo.domain.Member;

import java.util.List;

public record AllMembersListResponse(
        List<Member> members
) {
    public static AllMembersListResponse of(List<Member> members) {
        return new AllMembersListResponse(members);
    }
}
