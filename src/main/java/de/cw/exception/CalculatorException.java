package de.cw.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Data
@EqualsAndHashCode(callSuper = true)
public class CalculatorException extends RuntimeException {

    @Getter
    final String description;

    @Getter
    private final HttpStatus httpStatus;

    public CalculatorException(HttpStatus httpStatus, String description) {
        super();
        this.httpStatus = httpStatus;
        this.description = description;
    }

    public String getDescription() {
        return "{ \"errorMessage\": \"" + description + "\"}";
    }
}
