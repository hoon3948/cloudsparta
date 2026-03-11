package kr.spartaclub.cloudsparta.member.controller;

import kr.spartaclub.cloudsparta.member.dto.MemberResponse;
import kr.spartaclub.cloudsparta.member.dto.MemberSaveRequest;
import kr.spartaclub.cloudsparta.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @PostMapping("/api/members")
    public ResponseEntity<MemberResponse> addMember(@RequestBody MemberSaveRequest request) {
        log.info("멤버 생성 요청");
        return ResponseEntity.ok(memberService.addMember(request));
    }

    @GetMapping("/api/members/{id}")
    public ResponseEntity<MemberResponse> getMember(@PathVariable Long id) {
        log.info("멤버 조회 요청, id={}", id);
        return ResponseEntity.ok(memberService.getMember(id));
    }

//    @PostMapping("/api/members/{id}/profile-image")
//    public ResponseEntity<MemberResponse> addMemberProfileImage(
//            @PathVariable Long id, @RequestBody MemberImageRequest request
//    ) {
//
//    }
//
//    @GetMapping("/api/members/{id}/profile-image")
//    public ResponseEntity<MemberResponse> getMemberProfileImage(@PathVariable Long id) {
//
//    }
}
