package de.cw.configuration;

import de.cw.exception.CalculatorException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Slf4j
@ControllerAdvice
class CalculatorResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({CalculatorException.class})
    public ResponseEntity<Object> handleCalculatorException(CalculatorException exception) {
        log.warn(exception.getClass() + ", " + exception.getDescription());
        return new ResponseEntity<>(exception.getDescription(), new HttpHeaders(), exception.getHttpStatus());
    }

    @ExceptionHandler()
    public ResponseEntity<Object> handleInternalException(Exception exception) {
        log.error(exception.getClass() + ", " + exception.getCause() + ": " + exception.getMessage());
        return new ResponseEntity<>("", new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
