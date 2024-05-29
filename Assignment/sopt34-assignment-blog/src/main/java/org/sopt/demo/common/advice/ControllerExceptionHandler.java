package org.sopt.demo.common.advice;

import org.sopt.demo.common.dto.ResponseDto;
import org.sopt.demo.exception.ErrorMessage;
import org.sopt.demo.exception.model.BusinessException;
import org.sopt.demo.exception.model.ForbiddenException;
import org.sopt.demo.exception.model.NotFoundException;
import org.sopt.demo.exception.model.UnauthorizedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Objects;

@RestControllerAdvice
public class ControllerExceptionHandler {
    /**
     * 400 BAD REQUEST EXCEPTION
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<ResponseDto> handleMethodArgumentNotValidException(final MethodArgumentNotValidException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(ResponseDto.error(HttpStatus.BAD_REQUEST.value(), Objects.requireNonNull(e.getBindingResult().getFieldError().getDefaultMessage())));
    }

    /**
     * 401 FORBIDDEN EXCEPTION
     */
    @ExceptionHandler(UnauthorizedException.class)
    protected ResponseEntity<ResponseDto> handlerUnauthorizedException(UnauthorizedException e) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body(ResponseDto.error(HttpStatus.UNAUTHORIZED.value(), e.getErrorMessage().getMessage()));
    }

    /**
     * 403 FORBIDDEN EXCEPTION
     */
    @ExceptionHandler(ForbiddenException.class)
    protected ResponseEntity<ResponseDto> handleForbiddenException(final ForbiddenException e) {
        return ResponseEntity.status(HttpStatus.FORBIDDEN)
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
//    @ExceptionHandler(BusinessException.class)
//    protected ResponseEntity<ResponseDto> handleInternalServerError(final BusinessException e) {
//        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//                .body(ResponseDto.error(ErrorMessage.INTERNAL_SERVER_ERROR));
//    }
//
//    @ExceptionHandler(Exception.class)
//    protected ResponseEntity<ResponseDto> handleInternalServerError(final Exception e) {
//        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//                .body(ResponseDto.error(ErrorMessage.INTERNAL_SERVER_ERROR));
//    }
}
