package org.sopt.demo.service;

import lombok.RequiredArgsConstructor;
import org.sopt.demo.auth.UserAuthentication;
import org.sopt.demo.common.jwt.JwtTokenProvider;
import org.sopt.demo.domain.Member;
import org.sopt.demo.exception.ErrorMessage;
import org.sopt.demo.exception.model.NotFoundException;
import org.sopt.demo.repository.MemberRepository;
import org.sopt.demo.service.dto.response.AllMembersResponse;
import org.sopt.demo.service.dto.request.MemberCreateRequest;
import org.sopt.demo.service.dto.response.MemberFindResponse;
import org.sopt.demo.service.dto.response.UserJoinResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final JwtTokenProvider jwtTokenProvider;

    @Transactional
    public UserJoinResponse createMember(
            final MemberCreateRequest memberCreateRequest
    ) {
        Member member = memberRepository.save(
                Member.create(memberCreateRequest.name(), memberCreateRequest.part(), memberCreateRequest.age())
        );
        Long memberId = member.getId();
        String accessToken = jwtTokenProvider.issueAccessToken(
                UserAuthentication.createUserAuthentication(memberId)
        );
        return UserJoinResponse.of(accessToken, memberId.toString());
    }

    public Member findById(
            final Long memberId
    ) {
        return memberRepository.findById(memberId).orElseThrow(
                () -> new NotFoundException(ErrorMessage.MEMBER_NOT_FOUND)
        );
    }

    public MemberFindResponse findMemberById(
            final Long memberId
    ) {
        Member member = findById(memberId);
        return MemberFindResponse.of(member);
    }

    public AllMembersResponse findAllMembers() {
        return AllMembersResponse.of(memberRepository.findAll());
    }

    @Transactional
    public void deleteMemberById(
            final Long memberId
    ) {
        Member member = findById(memberId);
        memberRepository.delete(member);
    }
}
