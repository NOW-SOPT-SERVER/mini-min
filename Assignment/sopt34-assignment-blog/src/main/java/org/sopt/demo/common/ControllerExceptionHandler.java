package org.sopt.demo.common;

import org.sopt.demo.common.dto.ApiResponse;
import org.sopt.demo.exception.ErrorMessage;
import org.sopt.demo.exception.model.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    protected ResponseEntity<ApiResponse> handleNotFoundException(final NotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(ApiResponse.error(e.getErrorMessage(), e.getMessage()));
    }
}
