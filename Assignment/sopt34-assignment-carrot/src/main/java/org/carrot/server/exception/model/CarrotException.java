package org.carrot.server.exception.model;

import org.carrot.server.exception.ErrorMessage;

public class CarrotException extends RuntimeException {
    private final ErrorMessage errorMessage;

    public CarrotException(ErrorMessage errorMessage) {
        super(errorMessage.getMessage());
        this.errorMessage = errorMessage;
    }
}
