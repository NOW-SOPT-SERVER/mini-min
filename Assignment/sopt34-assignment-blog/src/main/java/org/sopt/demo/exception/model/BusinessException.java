package org.sopt.demo.exception.model;

import lombok.Getter;
import org.sopt.demo.exception.ErrorMessage;

@Getter
public class BusinessException extends RuntimeException {
    private final ErrorMessage errorMessage;

    public BusinessException(ErrorMessage errorMessage) {
        super(errorMessage.getMessage());
        this.errorMessage = errorMessage;
    }
}
