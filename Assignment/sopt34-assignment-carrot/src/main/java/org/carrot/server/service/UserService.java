package org.carrot.server.service;

import lombok.RequiredArgsConstructor;
import org.carrot.server.domain.User;
import org.carrot.server.exception.ErrorMessage;
import org.carrot.server.exception.model.BadRequestException;
import org.carrot.server.repository.UserRepository;
import org.carrot.server.service.dto.request.UserCreateRequest;
import org.carrot.server.service.dto.response.UserCreateResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    @Transactional
    public UserCreateResponse createUser(
        final UserCreateRequest userCreateRequest
    ) {
        isExistNickname(userCreateRequest.nickname());
        User user = User.create(userCreateRequest.nickname());
        userRepository.save(user);
        return UserCreateResponse.of(user);
    }

    public void isExistNickname(
            final String nickname
    ) {
       if (userRepository.existsByNickname(nickname)) {
           throw new BadRequestException(ErrorMessage.BAD_REQUEST_EXISTS_NICKNAME);
       }
    }
}
