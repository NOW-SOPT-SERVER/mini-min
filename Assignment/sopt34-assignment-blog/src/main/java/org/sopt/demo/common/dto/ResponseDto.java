package org.sopt.demo.common.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.sopt.demo.exception.ErrorMessage;
import org.sopt.demo.exception.SuccessMessage;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ResponseDto<T> {

    private final int status;
    private final String message;
    private T data;

    public static ResponseDto success(final SuccessMessage successMessage) {
        return new ResponseDto<>(successMessage.getStatus(), successMessage.getMessage());
    }

    public static <T> ResponseDto<T> success(final SuccessMessage successMessage, final T data) {
        return new ResponseDto<T>(successMessage.getStatus(), successMessage.getMessage(), data);
    }

    public static ResponseDto error(final int status, final String message) {
        return new ResponseDto<>(status, message);
    }

    public static ResponseDto error(final ErrorMessage errorMessage) {
        return new ResponseDto<>(errorMessage.getStatus(), errorMessage.getMessage());
    }
}
