package com.example.Ejercicio_Blog.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice(annotations = RestController.class)
public class ExceptionConfig {

    @ExceptionHandler(IdExistenteException.class)
    public ResponseEntity<?> IdExistenteException(Exception e){
        return ResponseEntity.badRequest().body(e.getMessage());
    }


}
