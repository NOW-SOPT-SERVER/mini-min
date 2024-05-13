package org.carrot.server.controller.product;

import lombok.RequiredArgsConstructor;
import org.carrot.server.common.dto.ResponseDto;
import org.carrot.server.exception.SuccessMessage;
import org.carrot.server.service.ProductService;
import org.carrot.server.service.dto.request.ProductCreateRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/product")
public class ProductController implements ProductControllerSwagger {

    private final ProductService productService;

    @Override
    @PostMapping
    public ResponseEntity<ResponseDto> createProduct(
            @RequestHeader final Long userId,
            @RequestBody final ProductCreateRequest productCreateRequest
    ) {
        productService.createProduct(userId, productCreateRequest);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ResponseDto.success(SuccessMessage.PRODUCT_CREATE_SUCCESS));
    }
}
