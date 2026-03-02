package kz.moderntech.controller.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

import java.util.NoSuchElementException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @ExceptionHandler(exception = ResponseStatusException.class)
    public ResponseEntity<ErrorMessage> handleNoSuchElementException(ResponseStatusException e) {
        logger.error(e.getLocalizedMessage());
        return new ResponseEntity<>(new ErrorMessage(e.getReason(), e.getStatusCode().value()), e.getStatusCode());
    }

    public record ErrorMessage(
            String message,
            int code
    ) {}

}
