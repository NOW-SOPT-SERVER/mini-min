package org.carrot.server.service.dto.response;

import lombok.AccessLevel;
import lombok.Builder;
import org.carrot.server.domain.User;

@Builder(access = AccessLevel.PRIVATE)
public record UserCreateResponse(
        Long id,
        String nickname
) {
    public static UserCreateResponse of(
            final User user
    ) {
        return builder()
                .id(user.getId())
                .nickname(user.getNickname())
                .build();
    }
}
