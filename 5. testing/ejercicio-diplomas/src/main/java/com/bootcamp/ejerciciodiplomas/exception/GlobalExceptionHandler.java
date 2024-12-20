package com.bootcamp.ejerciciodiplomas.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationException(MethodArgumentNotValidException ex) {
        // Create a map of field errors
        // Return appropriate error response
        Map<String, String> response = new HashMap<>();
        ex.getAllErrors().forEach(
                err -> response.put(err.getObjectName(), err.getDefaultMessage())
        );
        return ResponseEntity.badRequest().body(response);
    }
}
