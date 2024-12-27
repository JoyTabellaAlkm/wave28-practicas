package com.meli.obtenerdiploma.exceptions;

import com.meli.obtenerdiploma.model.ErrorDTO;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolationException;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler {

//    @ExceptionHandler(IllegalArgumentException.class)
//    public ResponseEntity<ErrorDTO> illegalArgumentException(IllegalArgumentException e){
//        return ResponseEntity.badRequest().body(new ErrorDTO("IllegalArgumentException",e.getMessage()));
//    }
//



    ////// METODOS DE VALIDACIONES ////////

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorDTO> validationException(MethodArgumentNotValidException e){

       ErrorDTO errorDTO = new ErrorDTO("Se encontraron los siguientes errores en las validaciones: @Valid del DTO",
               e.getAllErrors().stream()
                       .map(DefaultMessageSourceResolvable::getDefaultMessage)
                       .collect(Collectors.toList()).toString());

        return ResponseEntity.badRequest().body(errorDTO);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorDTO> handleValidationExceptions(HttpMessageNotReadableException e) {
        ErrorDTO error = new ErrorDTO("Se encontro un error con el formato del JSON, tipo de datos incorrectos, faltan campos, estructura inesperada o simplemente falta el cuerpo del RequestBody",
                e.getMostSpecificCause().getMessage());

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErrorDTO> validationException(ConstraintViolationException e){
        return ResponseEntity.badRequest().body(
                new ErrorDTO("Se encontraron los siguientes errores en las validaciones en el PathVariable y RequestParam ",
                        e.getConstraintViolations()
                                .stream()
                                .map(v-> v.getConstraintDescriptor().getMessageTemplate())
                                .collect(Collectors.toList())
                                .toString()
                )
        );
    }

}
