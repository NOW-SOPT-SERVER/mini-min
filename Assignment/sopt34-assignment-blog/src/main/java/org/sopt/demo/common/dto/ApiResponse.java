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
public class ApiResponse<T> {

    private final int status;
    private final String message;
    private T data;

    public static ApiResponse success(SuccessMessage successMessage) {
        return new ApiResponse<>(successMessage.getStatus(), successMessage.getMessage());
    }

    public static <T> ApiResponse<T> success(SuccessMessage successMessage, T data) {
        return new ApiResponse<T>(successMessage.getStatus(), successMessage.getMessage(), data);
    }

    public static ApiResponse error(ErrorMessage errorMessage) {
        return new ApiResponse<>(errorMessage.getStatus(), errorMessage.getMessage());
    }

    public static ApiResponse error(ErrorMessage errorMessage, String message) {
        return new ApiResponse<>(errorMessage.getStatus(), message);
    }
}
