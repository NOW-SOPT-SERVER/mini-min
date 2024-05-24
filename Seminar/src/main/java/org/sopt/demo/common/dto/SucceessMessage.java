package org.sopt.demo.common.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.net.http.HttpResponse;

@Getter
@AllArgsConstructor
public enum SucceessMessage {

    BLOG_CREATE_SUCCESS(HttpStatus.CREATED.value(), "블로그 생성이 완료되었습니다."),
    ;
    private final int status;
    private final String message;
}
