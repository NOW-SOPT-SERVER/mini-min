package org.sopt.demo.exception.model;

import org.sopt.demo.exception.ErrorMessage;

public class NotFoundException extends BusinessException {
    public NotFoundException(ErrorMessage errorMessage) {
        super(errorMessage);
    }
}
