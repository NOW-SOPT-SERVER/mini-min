package org.carrot.server.controller.user;

import lombok.RequiredArgsConstructor;
import org.carrot.server.common.dto.ResponseDto;
import org.carrot.server.exception.SuccessMessage;
import org.carrot.server.service.UserService;
import org.carrot.server.service.dto.request.UserCreateRequest;
import org.carrot.server.service.dto.response.UserCreateResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController implements UserControllerSwagger {
    private final UserService userService;

    @Override
    @PostMapping
    public ResponseEntity<ResponseDto<UserCreateResponse>> createUser(
            @RequestBody final UserCreateRequest userCreate
    ) {
        UserCreateResponse userCreateResponse = userService.createUser(userCreate);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ResponseDto.success(SuccessMessage.USER_CREATE_SUCCESS, userCreateResponse));
    }
}
