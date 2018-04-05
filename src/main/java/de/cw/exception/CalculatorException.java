package de.cw.exception;

import lombok.Data;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Data
public class CalculatorException extends RuntimeException {

    @Getter
    private final HttpStatus httpStatus;

    @Getter
    final String description;

    public CalculatorException(HttpStatus httpStatus, String description) {
        super();
        this.httpStatus = httpStatus;
        this.description = description;
    }

    public String getDescription() {
        return "{ \"errorMessage\": \"" + description + "\"}";
    }
}
