package kr.spartaclub.cloudsparta.member.service;

import kr.spartaclub.cloudsparta.member.dto.MemberResponse;
import kr.spartaclub.cloudsparta.member.dto.MemberSaveRequest;
import kr.spartaclub.cloudsparta.member.entity.Member;
import kr.spartaclub.cloudsparta.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
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
//        log.info("멤버 생성 성공");
        Member savedMember = memberRepository.save(member);
//        log.info("savedMember id = {}", savedMember.getId());
//        log.info("name = {}", savedMember.getName());
//        log.info("age = {}", savedMember.getAge());
//        log.info("mbti = {}", savedMember.getMbti());
        return new MemberResponse(savedMember);
    }

    @Transactional(readOnly = true)
    public MemberResponse getMember(Long id) {
        Member member = memberRepository.findById(id).orElseThrow(
                () -> {
                    log.warn("찾을 수 없는 멤버 아이디:" + id);
                    return new IllegalArgumentException("Member with id: " + id + " does not exist");
                }
        );

        log.info("멤버 조회 성공");
        return new MemberResponse(member);
    }
}
