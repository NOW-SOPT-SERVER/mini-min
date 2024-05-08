package org.carrot.server.controller.product;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.carrot.server.common.dto.ResponseDto;
import org.carrot.server.service.dto.request.ProductCreateRequest;
import org.carrot.server.service.dto.request.UserCreateRequest;
import org.carrot.server.service.dto.response.UserCreateResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@Tag(name = "물건", description = "물건 관련 API 입니다.")
public interface ProductControllerSwagger {

    @Operation(summary = "물건 생성 API")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "새로운 물건이 생성되었습니다.")
    })
    ResponseEntity<ResponseDto> createProduct(
            @RequestHeader final Long userId,
            @RequestBody final ProductCreateRequest productCreateRequest
    );
}
