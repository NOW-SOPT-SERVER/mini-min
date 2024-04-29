package org.sopt.demo.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorMessage {
    /**
     * 400 BAD REQUEST EXCEPTION
     */
    BAD_REQUEST_BLOG_NAME(HttpStatus.BAD_REQUEST.value(), "ID에 해당하는 사용자가 존재하지 않습니다."),

    /**
     * 404 NOT FOUND
     */
    MEMBER_NOT_FOUND(HttpStatus.NOT_FOUND.value(), "ID에 해당하는 사용자가 존재하지 않습니다."),
    BLOG_NOT_FOUND(HttpStatus.NOT_FOUND.value(), "해당 블로그가 존재하지 않습니다."),
    POST_NOT_FOUND(HttpStatus.NOT_FOUND.value(), "존재하지 않는 블로그 글입니다.")

    ;
    private final int status;
    private final String message;
}
