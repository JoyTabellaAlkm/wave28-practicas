package com.meli.obtenerdiploma.exception;

import com.meli.obtenerdiploma.model.ErrorDTO;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorDTO> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        ErrorDTO errorDTO = new ErrorDTO("Se encontraron los siguientes errores en las validaciones: @Valid del DTO",
                e.getAllErrors().stream()
                        .map(DefaultMessageSourceResolvable::getDefaultMessage)
                        .collect(Collectors.toList()).toString());
        return ResponseEntity.badRequest().body(errorDTO);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorDTO> handleHttpMessageNotReadableException(HttpMessageNotReadableException e) {
        ErrorDTO errorDTO = new ErrorDTO("Se encontro un error con el formato del JSON, tipo de datos incorrectos, faltan campos, estructura inesperada o simplemente falta el cuerpo del RequestBody",
                e.getMostSpecificCause().getMessage());
        return ResponseEntity.badRequest().body(errorDTO);
    }
}
