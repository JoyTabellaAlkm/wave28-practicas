package com.bootcamp.ejercicioblog.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice(annotations = RestController.class)
public class GlobalExceptioHandler {

    @ExceptionHandler(EntradaBlogYaExisteException.class)
    public ResponseEntity<?> EntradaBlogYaExisteException(Exception e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

    @ExceptionHandler(EntradaBlogNoExisteException.class)
    public ResponseEntity<?> EntradaBlogNoExisteException(Exception e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }
}
