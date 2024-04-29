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
    GET_POST_SUCCESS(HttpStatus.OK.value(), "블로그 글 조회 성공했습니다."),

    /**
     * 201 CREATED SUCCESS
     */
    BLOG_CREATE_SUCCESS(HttpStatus.CREATED.value(), "블로그 생성이 완료되었습니다."),
    BLOG_POST_CREATE_SUCCESS(HttpStatus.CREATED.value(), "블로그 글 작성이 완료되었습니다.")
    ;

    private final int status;
    private final String message;
}
