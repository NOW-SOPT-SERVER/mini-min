package org.sopt.demo.service.dto;

import org.sopt.demo.domain.Member;

import java.util.List;

public record AllMembersListDto(
        List<Member> members
) {
    public static AllMembersListDto of(List<Member> members) {
        return new AllMembersListDto(members);
    }
}
