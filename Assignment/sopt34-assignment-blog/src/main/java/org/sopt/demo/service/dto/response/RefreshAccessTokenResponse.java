package org.sopt.demo.service.dto.response;

public record RefreshAccessTokenResponse(
        String accessToken
) {
    public static RefreshAccessTokenResponse of(
            String accessToken
    ) {
        return new RefreshAccessTokenResponse(accessToken);
    }
}
