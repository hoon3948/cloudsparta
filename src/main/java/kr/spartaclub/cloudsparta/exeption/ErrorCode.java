package kr.spartaclub.cloudsparta.exeption;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {

    // Member 관련 에러 (M으로 시작)
    MEMBER_NOT_FOUND(HttpStatus.NOT_FOUND, "M001", "멤버을 찾을 수 없습니다."),

    FILE_NOT_FOUND(HttpStatus.NOT_FOUND, "F001", "파일을 찾을 수 없습니다."),
//    FILE_UPLOAD_FAILED(HttpStatus. , "F002", "파일 업로드에 실패했습니다"), //status 고민중...

    INVALID_PASSWORD(HttpStatus.UNAUTHORIZED, "P001", "비밀번호가 일치하지 않습니다."),

    // 공통 에러 (C로 시작)
    INVALID_INPUT_VALUE(HttpStatus.BAD_REQUEST, "C001", "잘못된 입력값입니다."),
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "C002", "서버 내부 오류가 발생했습니다.");

    private final HttpStatus status;
    private final String code;
    private final String message;

}
