package org.carrot.server.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ErrorMessage {
    /**
     * 400 BAD REQUEST EXCEPTION
     */
    BAD_REQUEST_EXISTS_NICKNAME(HttpStatus.BAD_REQUEST.value(), "이미 존재하는 닉네임입니다."),

    /**
     * 403 FORBIDDEN EXCEPTION
     */

    /**
     * 404 NOT FOUND
     */
    USER_NOT_FOUND(HttpStatus.NOT_FOUND.value(), "ID에 해당하는 사용자가 존재하지 않습니다."),

    /**
     * 500 INTERNAL SERVER ERROR
     */
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR.value(), "서버 내부 오류입니다."),
    ;

    private final int status;
    private final String message;
}
