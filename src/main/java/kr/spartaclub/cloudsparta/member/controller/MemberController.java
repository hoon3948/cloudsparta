package kr.spartaclub.cloudsparta.member.controller;

import kr.spartaclub.cloudsparta.member.dto.MemberResponse;
import kr.spartaclub.cloudsparta.member.dto.MemberSaveRequest;
import kr.spartaclub.cloudsparta.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @PostMapping("/api/members")
    public ResponseEntity<MemberResponse> addMember(MemberSaveRequest request) {
        return ResponseEntity.ok(memberService.addMember(request));
    }

    @GetMapping("/api/members/{id}")
    public ResponseEntity<MemberResponse> getMember(@PathVariable Long id) {
        return ResponseEntity.ok(memberService.getMember(id));
    }
}
