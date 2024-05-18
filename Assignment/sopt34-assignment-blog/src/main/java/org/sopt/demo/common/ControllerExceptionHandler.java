package org.sopt.demo.common;

import org.sopt.demo.exception.ErrorMessage;
import org.sopt.demo.exception.model.BusinessException;
import org.sopt.demo.exception.model.ForbiddenException;
import org.sopt.demo.exception.model.NotFoundException;
import org.sopt.demo.exception.model.UnauthorizedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
    @ExceptionHandler(BusinessException.class)
    protected ResponseEntity<ResponseDto> handleInternalServerError(final BusinessException e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(ResponseDto.error(ErrorMessage.INTERNAL_SERVER_ERROR));
    }

    @ExceptionHandler(Exception.class)
    protected ResponseEntity<ResponseDto> handleInternalServerError(final Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(ResponseDto.error(ErrorMessage.INTERNAL_SERVER_ERROR));
    }

    @Component
    public static class DateUtil {

        private static final String YEAR = "년";
        private static final String MONTH = "월";
        private static final String DAY = "일";
        private static final String STRING_DATE_WITH_TIME = "yyyy-MM-dd HH:mm";

        /*
            yyyy년 MM월 dd일 이 필요할 때 사용
        */
        public static String getKoreanStringOfLocalDate(
                final LocalDateTime localDateTime
        ) {
            return getKoreanString(localDateTime);
        }

        /*
            yyyy-MM-dd HH:mm 이 필요할 때 사용
        */
        public static String getStringWithTimeOfLocalDate(
                final LocalDateTime localDateTime
        ) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(STRING_DATE_WITH_TIME);
            return localDateTime.format(formatter);
        }

        private static String getKoreanString(
                final LocalDateTime localDateTime
        ) {
            return getYearStringValueOfLocalDate(localDateTime) + YEAR + " "
                    + getMonthStringValueOfLocalDate(localDateTime) + MONTH + " "
                    + getDayOfMonthStringValueOfLocalDate(localDateTime) + DAY;
        }

        private static String getYearStringValueOfLocalDate(
                final LocalDateTime localDateTime
        ) {
            return String.valueOf(localDateTime.getYear());
        }

        private static String getMonthStringValueOfLocalDate(
                final LocalDateTime localDateTime
        ) {
            return String.valueOf(localDateTime.getMonthValue());
        }

        private static String getDayOfMonthStringValueOfLocalDate(
                final LocalDateTime localDateTime
        ) {
            return String.valueOf(localDateTime.getDayOfMonth());
        }
    }
}
