package com.meli.obtenerdiploma.exceptions;

import com.meli.obtenerdiploma.model.ErrorDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorDTO> validationException(MethodArgumentNotValidException e){

        ErrorDTO errorDTO = new ErrorDTO("Se encontraron los siguientes errores en las validaciones: @Valid del DTO",
                e.getAllErrors().stream()
                        .map(DefaultMessageSourceResolvable::getDefaultMessage)
                        .collect(Collectors.toList()).toString());

        return ResponseEntity.badRequest().body(errorDTO);
    }
}
