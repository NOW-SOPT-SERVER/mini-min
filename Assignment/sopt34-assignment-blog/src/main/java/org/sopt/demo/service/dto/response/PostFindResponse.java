package org.sopt.demo.service.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import org.sopt.demo.common.utils.DateUtil;
import org.sopt.demo.domain.Post;

public record PostFindResponse(
        String title,
        String content,
        @Schema(defaultValue = "2024-05-05 12:34")
        String createdAt,
        @Schema(defaultValue = "2024-05-05 12:34")
        String updatedAt
) {
    public static PostFindResponse of(
            final Post post
    ) {
        return new PostFindResponse(
                post.getTitle(),
                post.getContent(),
                DateUtil.getStringWithTimeOfLocalDate(post.getCreatedAt()),
                DateUtil.getStringWithTimeOfLocalDate(post.getUpdatedAt())
        );
    }
}
