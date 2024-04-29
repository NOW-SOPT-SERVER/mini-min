package org.sopt.demo.service.dto.response;

import org.sopt.demo.domain.Post;

import java.time.LocalDateTime;

public record PostFindResponse(
        String title,
        String content,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
    public static PostFindResponse of(
            Post post
    ) {
        return new PostFindResponse(post.getTitle(), post.getContent(), post.getCreatedAt(), post.getUpdatedAt());
    }
}
