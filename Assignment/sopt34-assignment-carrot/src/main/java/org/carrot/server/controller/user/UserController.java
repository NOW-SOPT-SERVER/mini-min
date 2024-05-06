package org.carrot.server.controller.user;

import lombok.RequiredArgsConstructor;
import org.carrot.server.common.dto.ResponseDto;
import org.carrot.server.exception.SuccessMessage;
import org.carrot.server.service.UserService;
import org.carrot.server.service.dto.request.UserCreateRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class UserController implements UserControllerSwagger {
    private final UserService userService;

    @PostMapping("/user")
    public ResponseEntity<ResponseDto> createUser(
            @RequestBody final UserCreateRequest userCreate
    ) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .header("Location", userService.createUser(userCreate))
                .body(ResponseDto.success(SuccessMessage.USER_CREATE_SUCCESS));
    }
}
