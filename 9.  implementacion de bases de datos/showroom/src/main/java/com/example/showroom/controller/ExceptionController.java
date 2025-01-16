package com.example.showroom.controller;

import com.example.showroom.dto.MessageDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

@RestControllerAdvice
public class ExceptionController {

    @ExceptionHandler({ NoSuchElementException.class })
    public ResponseEntity<?> noSuchElement() {
        return new ResponseEntity<>(new MessageDto("La prenda no existe"), HttpStatus.NOT_FOUND);
    }

}
