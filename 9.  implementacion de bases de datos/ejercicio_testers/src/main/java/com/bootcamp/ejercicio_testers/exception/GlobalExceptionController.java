package com.bootcamp.ejercicio_testers.exception;

import com.bootcamp.ejercicio_testers.dto.ExceptionResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionController {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ExceptionResponseDTO> handleUserNotFoundException(NotFoundException e) {
        return new ResponseEntity<>(new ExceptionResponseDTO("404", e.getMessage()), HttpStatus.NOT_FOUND);
    }
}
