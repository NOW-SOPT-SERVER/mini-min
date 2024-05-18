package org.sopt.demo.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;

@Getter
@AllArgsConstructor
public enum ErrorMessage {
    /**
     * 400 BAD REQUEST EXCEPTION
     */
    BAD_REQUEST_BLOG_NAME(HttpStatus.BAD_REQUEST.value(), "블로그 제목이 최대 글자 수(10자)를 초과했습니다."),

    /**
     * 401 FORBIDDEN EXCEPTION
     */
    JWT_UNAUTHORIZED_EXCEPTION(HttpStatus.UNAUTHORIZED.value(), "사용자의 로그인 검증을 실패했습니다."),

    /**
     * 403 FORBIDDEN EXCEPTION
     */
    POST_USER_FORBIDDEN(HttpStatus.FORBIDDEN.value(), "해당 사용자는 해당 블로그에 대한 접근 권한(글 작성, 수정, 삭제)이 없습니다."),

    /**
     * 404 NOT FOUND
     */
    MEMBER_NOT_FOUND(HttpStatus.NOT_FOUND.value(), "ID에 해당하는 사용자가 존재하지 않습니다."),
    BLOG_NOT_FOUND(HttpStatus.NOT_FOUND.value(), "해당 블로그가 존재하지 않습니다."),
    POST_NOT_FOUND(HttpStatus.NOT_FOUND.value(), "존재하지 않는 블로그 글을 조회하고 있습니다."),

    /**
     * 500 INTERNAL SERVER ERROR
     */
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR.value(), "서버 내부 오류입니다."),
    ;

    private final int status;
    @Getter
    private final String message;
}
