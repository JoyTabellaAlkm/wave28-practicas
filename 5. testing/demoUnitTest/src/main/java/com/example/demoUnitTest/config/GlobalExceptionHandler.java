package com.example.demoUnitTest.config;

import com.example.demoUnitTest.dto.ErrorDTO;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorDTO> validationException(MethodArgumentNotValidException e) {
        return ResponseEntity.badRequest().body(
                new ErrorDTO("Se encontraron los siguientes errores en las validaciones: @Valid del DTO",
                        e.getAllErrors()
                                .stream()
                                .map(ObjectError::getDefaultMessage)
                                .toList()
                )
        );
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErrorDTO> validationException(ConstraintViolationException e) {
        return ResponseEntity.badRequest().body(
                new ErrorDTO("Se encontraron los siguientes errores en las validaciones en el PathVariable y RequestParam ",
                        e.getConstraintViolations().stream()
                                .map(ConstraintViolation::getMessage)
                                .toList()
                )

        );
    }
}
