package org.sopt.demo.auth.redis.repository;

import org.sopt.demo.auth.redis.domain.Token;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RedisTokenRepository extends CrudRepository<Token, Long> {
    Optional<Token> findByRefreshToken(final String refreshToken);
    Optional<Token> findById(final Long id);
}
