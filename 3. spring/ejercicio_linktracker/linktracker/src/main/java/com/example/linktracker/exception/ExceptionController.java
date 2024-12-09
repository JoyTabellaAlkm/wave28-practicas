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
        public ResponseEntity<?> NotValidLinkException (NotValidLinkException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }

        @ExceptionHandler(NotFoundException.class)
        public ResponseEntity<?> NotFoundException (NotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
}
