package org.sopt.demo.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.sopt.demo.domain.Member;
import org.sopt.demo.exception.ErrorMessage;
import org.sopt.demo.exception.model.NotFoundException;
import org.sopt.demo.repository.MemberRepository;
import org.sopt.demo.service.dto.response.AllMembersResponse;
import org.sopt.demo.service.dto.request.MemberCreateRequest;
import org.sopt.demo.service.dto.response.MemberFindResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public String createMember(
            MemberCreateRequest memberCreateRequest
    ) {
        Member member = Member.create(memberCreateRequest.name(), memberCreateRequest.part(), memberCreateRequest.age());
        memberRepository.save(member);
        return member.getId().toString();
    }

    public Member findById(
            Long memberId
    ) {
        return memberRepository.findById(memberId).orElseThrow(
                () -> new NotFoundException(ErrorMessage.MEMBER_NOT_FOUND)
        );
    }

    public MemberFindResponse findMemberById(
            Long memberId
    ) {
        Member member = findById(memberId);
        return MemberFindResponse.of(member);
    }

    public AllMembersResponse findAllMembers() {
        return AllMembersResponse.of(memberRepository.findAll());
    }

    @Transactional
    public void deleteMemberById(
            Long memberId
    ) {
        Member member = findById(memberId);
        memberRepository.delete(member);
    }
}
