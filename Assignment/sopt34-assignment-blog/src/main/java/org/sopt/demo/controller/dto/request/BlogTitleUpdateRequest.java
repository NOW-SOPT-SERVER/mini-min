package org.sopt.demo.controller.dto.request;

import jakarta.validation.constraints.Size;

public record BlogTitleUpdateRequest(
        @Size(max = 10, message = "블로그 제목이 최대 글자 수(10자)를 초과했습니다.")
        String title
) {
}
