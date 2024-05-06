package org.carrot.server.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum SuccessMessage {
    /**
     * 200 OK SUCCESS
     */

    /**
     * 201 CREATED SUCCESS
     */
    USER_CREATE_SUCCESS(HttpStatus.CREATED.value(), "새로운 유저가 생성되었습니다."),

    /**
     * 204 NO_CONTENT SUCCESS
     */
    ;

    private final int status;
    private final String message;
}
