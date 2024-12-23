package com.meli.obtenerdiploma.exception;

import com.meli.obtenerdiploma.model.ExceptionDto;
import jakarta.validation.ConstraintViolationException;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.stream.Collectors;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ExceptionDto> validationException(MethodArgumentNotValidException e){

        ExceptionDto errorDTO = new ExceptionDto("Se encontraron los siguientes errores en las validaciones: @Valid del DTO",
                e.getAllErrors().stream()
                        .map(DefaultMessageSourceResolvable::getDefaultMessage)
                        .toList().toString());

        return ResponseEntity.badRequest().body(errorDTO);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ExceptionDto> handleValidationExceptions(HttpMessageNotReadableException e) {
        ExceptionDto error = new ExceptionDto("Se encontro un error con el formato del JSON, tipo de datos incorrectos, faltan campos, estructura inesperada o simplemente falta el cuerpo del RequestBody",
                e.getMostSpecificCause().getMessage());

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ExceptionDto> validationException(ConstraintViolationException e){
        return ResponseEntity.badRequest().body(
                new ExceptionDto("Se encontraron los siguientes errores en las validaciones en el PathVariable y RequestParam ",
                        e.getConstraintViolations()
                                .stream()
                                .map(v-> v.getConstraintDescriptor().getMessageTemplate())
                                .toList()
                                .toString()
                )
        );
    }

}