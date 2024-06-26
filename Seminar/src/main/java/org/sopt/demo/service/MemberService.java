package org.sopt.demo.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.sopt.demo.common.dto.ErrorMessage;
import org.sopt.demo.domain.Member;
import org.sopt.demo.exception.NotFoundException;
import org.sopt.demo.repository.MemberRepository;
import org.sopt.demo.service.dto.MemberCreateDto;
import org.sopt.demo.service.dto.MemberFindDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional  // 변경사항을 DB에 반영해주기 위한 어노테이션
    public String createMember(
            MemberCreateDto memberCreateDto
    ) {
        Member member = Member.create(memberCreateDto.name(), memberCreateDto.part(), memberCreateDto.age());
        memberRepository.save(member);      // memberRepository 내부에 save 메서드를 이용해 객체를 DB에 반영
        return member.getId().toString();
    }

    public Member findById(Long memberId) {
        return memberRepository.findById(memberId).orElseThrow(
                () -> new NotFoundException(ErrorMessage.MEMBER_NOT_FOUND)
        );
    }
    public MemberFindDto findMemberById(
            Long memberId
    ) {
        return MemberFindDto.of(memberRepository.findById(memberId).orElseThrow(
                () -> new EntityNotFoundException("ID에 해당하는 사용자가 존재하지 않습니다.")
        ));
    }

    @Transactional
    public void deleteMemberById(
            Long memberId
    ) {
        Member member = memberRepository.findById(memberId).orElseThrow(
                () -> new EntityNotFoundException("ID에 해당하는 사용자가 존재하지 않습니다.")
        );
        memberRepository.delete(member);
    }
}
