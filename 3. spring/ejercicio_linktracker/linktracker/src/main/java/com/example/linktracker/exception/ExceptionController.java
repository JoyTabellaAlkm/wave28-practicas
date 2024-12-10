package com.example.linktracker.exception;

import com.example.linktracker.exception.customizedExceptions.NotFoundException;
import com.example.linktracker.exception.customizedExceptions.NotValidLinkException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {

    @ExceptionHandler(NotValidLinkException.class)
    public ResponseEntity<?> notValidException(NotValidLinkException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> notFoundException(NotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }

//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<?> notHandledException(Exception e){
//        //podría loguear la excepcion
//        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Hubo un error interno");
//    }
}
