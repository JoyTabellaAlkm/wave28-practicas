package com.example.Ejercicio_LinkTracker.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice(annotations = RestController.class)
public class ExceptionConfig {

    @ExceptionHandler(UrlNotFoundException.class)
    public ResponseEntity<?> UrlNotFoundException(Exception e){
        return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
    }


}
