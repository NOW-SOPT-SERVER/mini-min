package org.carrot.server.exception.model;

import org.carrot.server.exception.ErrorMessage;

public class BadRequestException extends CarrotException {
    public BadRequestException(ErrorMessage errorMessage) {
        super(errorMessage);
    }
}
