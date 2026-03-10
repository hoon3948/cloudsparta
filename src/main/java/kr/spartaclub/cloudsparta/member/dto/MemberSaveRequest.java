package kr.spartaclub.cloudsparta.member.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MemberSaveRequest {
    private String name;
    private int age;
    private String mbti;
}
