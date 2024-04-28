package org.sopt.demo.service.dto.request;

public record BlogPostCreateRequest(
        String title,
        String content
) {
}
