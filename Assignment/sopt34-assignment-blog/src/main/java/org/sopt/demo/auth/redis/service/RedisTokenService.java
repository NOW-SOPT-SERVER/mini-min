package org.sopt.demo.auth.redis.service;

import lombok.RequiredArgsConstructor;
import org.sopt.demo.auth.redis.domain.Token;
import org.sopt.demo.auth.redis.repository.RedisTokenRepository;
import org.sopt.demo.exception.ErrorMessage;
import org.sopt.demo.exception.model.UnauthorizedException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RedisTokenService {
    private final RedisTokenRepository redisTokenRepository;

    public void saveRefreshToken(
            final Long memberId,
            final String refreshToken
    ) {
        Token token = Token.of(memberId, refreshToken);
        redisTokenRepository.save(token);
    }

    public Long findMemberIdByRefreshToken(
            final String refreshToken
    ) {
        return redisTokenRepository.findByRefreshToken(refreshToken).orElseThrow(
                () -> new UnauthorizedException(ErrorMessage.LOGIN_REQUIRED_EXCEPTION)
        ).getId();
    }
}
