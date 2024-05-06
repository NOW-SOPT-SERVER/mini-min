package org.carrot.server.service;

import lombok.RequiredArgsConstructor;
import org.carrot.server.domain.User;
import org.carrot.server.repository.UserRepository;
import org.carrot.server.service.dto.request.UserCreateRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    @Transactional
    public String createUser(
        final UserCreateRequest userCreateRequest
    ) {
        User user = User.create(userCreateRequest.nickname());
        userRepository.save(user);
        return user.getId().toString();
    }
}
