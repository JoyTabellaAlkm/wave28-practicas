package com.meli.obtenerdiploma.exception;

import com.meli.obtenerdiploma.dto.ResponseDto;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.stream.Collectors;

@ControllerAdvice
public class ExceptionController{

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> validator(MethodArgumentNotValidException e) {
        String errorMessage = e.getBindingResult().getAllErrors().stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.joining(", "));

        return new ResponseEntity<>(new ResponseDto(errorMessage), HttpStatus.BAD_REQUEST);
    }
}
