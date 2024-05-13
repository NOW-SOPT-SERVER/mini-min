package org.carrot.server.exception.model;

import lombok.Getter;
import org.carrot.server.exception.ErrorMessage;

@Getter
public class NotFoundException extends CarrotException {
    public NotFoundException(ErrorMessage errorMessage) {
        super(errorMessage);
    }
}
