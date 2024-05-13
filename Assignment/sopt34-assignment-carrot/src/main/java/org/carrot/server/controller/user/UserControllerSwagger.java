package org.carrot.server.controller.user;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.carrot.server.common.dto.ResponseDto;
import org.carrot.server.service.dto.request.UserCreateRequest;
import org.carrot.server.service.dto.response.UserCreateResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

@Tag(name = "유저", description = "유저 관련 API 입니다.")
public interface UserControllerSwagger {

    @Operation(summary = "유저 생성 API")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "새로운 유저가 생성되었습니다."),
            @ApiResponse(responseCode = "400", description = "이미 존재하는 닉네임입니다.",
                    content = @Content(schema = @Schema(implementation = ResponseDto.class)))
    })
    ResponseEntity<ResponseDto<UserCreateResponse>> createUser(
            @RequestBody final UserCreateRequest userCreate
    );
}
