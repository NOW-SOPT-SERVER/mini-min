package org.sopt.demo.exception.model;

import org.sopt.demo.exception.ErrorMessage;

public class ForbiddenException extends BusinessException {
    public ForbiddenException(ErrorMessage errorMessage) {
        super(errorMessage);
    }
}
