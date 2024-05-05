package org.sopt.demo.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum SuccessMessage {
    /**
     * 200 OK SUCCESS
     */
    GET_MEMBER_SUCCESS(HttpStatus.OK.value(), "특정 멤버 조회를 성공했습니다."),
    GET_ALL_MEMBER_SUCCESS(HttpStatus.OK.value(), "전체 멤버 조회를 성공했습니다."),
    GET_POST_SUCCESS(HttpStatus.OK.value(), "블로그 글 조회에 성공했습니다."),

    /**
     * 201 CREATED SUCCESS
     */
    MEMBER_CREATE_SUCCESS(HttpStatus.CREATED.value(), "멤버 가입이 완료되었습니다."),
    BLOG_CREATE_SUCCESS(HttpStatus.CREATED.value(), "블로그 생성이 완료되었습니다."),
    BLOG_POST_CREATE_SUCCESS(HttpStatus.CREATED.value(), "블로그 글 작성이 완료되었습니다."),

    /**
     * 204 NO_CONTENT SUCCESS
     */
    MEMBER_DELETE_SUCCESS(HttpStatus.NO_CONTENT.value(), "멤버 삭제가 완료되었습니다."),
    BLOG_NAME_PATCH_SUCCESS(HttpStatus.NO_CONTENT.value(), "블로그 이름 수정이 완료되었습니다.")
    ;

    private final int status;
    private final String message;
}
