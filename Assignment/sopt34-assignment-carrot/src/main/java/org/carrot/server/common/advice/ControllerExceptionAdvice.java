package org.carrot.server.common.advice;

import org.carrot.server.common.dto.ResponseDto;
import org.carrot.server.exception.ErrorMessage;
import org.carrot.server.exception.model.CarrotException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class ControllerExceptionAdvice {
    /**
     * 500 INTERNAL SERVER ERROR
     */
    @ExceptionHandler(CarrotException.class)
    protected ResponseEntity<ResponseDto> handleInternalServerError(final CarrotException e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(ResponseDto.error(ErrorMessage.INTERNAL_SERVER_ERROR));
    }

    @ExceptionHandler(Exception.class)
    protected ResponseEntity<ResponseDto> handleInternalServerError(final Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(ResponseDto.error(ErrorMessage.INTERNAL_SERVER_ERROR));
    }
}
