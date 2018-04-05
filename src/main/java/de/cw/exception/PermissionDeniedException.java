package de.cw.exception;

import org.springframework.http.HttpStatus;

public class PermissionDeniedException extends CalculatorException {

    public PermissionDeniedException() {
        super(HttpStatus.FORBIDDEN, "PermissionDenied");
    }

}
