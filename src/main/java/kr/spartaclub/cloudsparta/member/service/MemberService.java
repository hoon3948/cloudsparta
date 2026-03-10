package kr.spartaclub.cloudsparta.member.service;

import kr.spartaclub.cloudsparta.member.dto.MemberResponse;
import kr.spartaclub.cloudsparta.member.dto.MemberSaveRequest;
import kr.spartaclub.cloudsparta.member.entity.Member;
import kr.spartaclub.cloudsparta.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    @Transactional
    public MemberResponse addMember(MemberSaveRequest request) {
        Member member = new Member(
                request.getName(),
                request.getAge(),
                request.getMbti()
        );

        return new MemberResponse(member);
    }

    @Transactional(readOnly = true)
    public MemberResponse getMember(Long id) {
        Member member = memberRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("Member with id: " + id + " does not exist")
        );
        return new MemberResponse(member);
    }
}
