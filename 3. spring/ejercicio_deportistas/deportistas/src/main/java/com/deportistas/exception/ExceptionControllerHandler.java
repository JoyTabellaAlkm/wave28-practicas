package com.deportistas.exception;

import com.deportistas.dto.ExceptionDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionControllerHandler {

    @ExceptionHandler(NotFoundException.class)
    protected ResponseEntity<ExceptionDto> handleFailedDependencyException(NotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ExceptionDto(e.getMessage()));
    }
}
