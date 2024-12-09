package com.mercadolibre.linktracker.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalHandlerException {

    @ExceptionHandler(InvalidPasswordException.class)
    public ResponseEntity<?> invalidPasswordException(InvalidPasswordException e) {
        return new ResponseEntity<>(
                new ModelException(
                        e.getMessage(),
                        HttpStatus.BAD_REQUEST,
                        LocalDateTime.now()
                ),
                HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(InvalidUrlException.class)
    public ResponseEntity<?> invalidUrlException(InvalidUrlException e) {
        return new ResponseEntity<>(
                new ModelException(
                        e.getMessage(),
                        HttpStatus.BAD_REQUEST,
                        LocalDateTime.now()
                ),
                HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> resourceNotFoundException(ResourceNotFoundException e) {
        return new ResponseEntity<>(
                new ModelException(
                        e.getMessage(),
                        HttpStatus.NOT_FOUND,
                        LocalDateTime.now()
                ),
                HttpStatus.NOT_FOUND
        );
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> globalException(Exception e) {
        return new ResponseEntity<>(
                new ModelException(
                        e.getMessage(),
                        HttpStatus.INTERNAL_SERVER_ERROR,
                        LocalDateTime.now()
                ),
                HttpStatus.INTERNAL_SERVER_ERROR
        );
    }
}
