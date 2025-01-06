package com.bootcamp.social_meli.exception;

import com.bootcamp.social_meli.dto.response.ExceptionResponseDTO;
import com.bootcamp.social_meli.dto.response.ParsingErrorResponseDTO;
import com.bootcamp.social_meli.dto.response.ValidationErrorResponseDTO;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionController {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ExceptionResponseDTO> handleUserNotFoundException(NotFoundException e) {
        return new ResponseEntity<>(new ExceptionResponseDTO("404", e.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ExceptionResponseDTO> handleBadRequestException(BadRequestException e) {
        return new ResponseEntity<>(new ExceptionResponseDTO("400", e.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ConflictException.class)
    public ResponseEntity<ExceptionResponseDTO> handleConflictException(ConflictException e) {
        return new ResponseEntity<>(new ExceptionResponseDTO("409", e.getMessage()), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidationErrorResponseDTO> handleValidationExceptions(MethodArgumentNotValidException ex) {
        ValidationErrorResponseDTO response = new ValidationErrorResponseDTO();
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));
        response.setMessage("Se encontrarón errores en algunos campos.");
        response.setStatus(HttpStatus.BAD_REQUEST.value());
        response.setErrors(errors);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ExceptionResponseDTO> handleValidationExceptions(ConstraintViolationException ex) {
        String errorMessage = ex.getConstraintViolations().iterator().next().getMessage();
        return new ResponseEntity<>(new ExceptionResponseDTO("400", errorMessage),
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ParsingErrorResponseDTO> handleHttpMessageNotReadableException(HttpMessageNotReadableException ex) {
        ParsingErrorResponseDTO response = new ParsingErrorResponseDTO();
        response.setMessage("Algunos datos no cumplen con el formato requerido.");
        response.setStatus(HttpStatus.BAD_REQUEST.value());
        response.setCaused_by(ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
