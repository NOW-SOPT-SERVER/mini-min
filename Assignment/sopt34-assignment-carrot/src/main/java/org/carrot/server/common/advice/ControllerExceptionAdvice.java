package org.carrot.server.common.advice;

import org.carrot.server.common.dto.ResponseDto;
import org.carrot.server.exception.ErrorMessage;
import org.carrot.server.exception.model.BadRequestException;
import org.carrot.server.exception.model.CarrotException;
import org.carrot.server.exception.model.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerExceptionAdvice {

    /**
     * 400 BAD REQUEST EXCEPTION
     */
    @ExceptionHandler(BadRequestException.class)
    protected ResponseEntity<ResponseDto> handleBadRequestException(final BadRequestException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(ResponseDto.error(e.getErrorMessage()));
    }

    /**
     * 404 NOT FOUND EXCEPTION
     */
    @ExceptionHandler(NotFoundException.class)
    protected ResponseEntity<ResponseDto> handleNotFoundException(final NotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(ResponseDto.error(e.getErrorMessage()));
    }

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
