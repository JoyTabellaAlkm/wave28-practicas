package ar.com.mercadolibre.mundial.controller;

import ar.com.mercadolibre.mundial.dto.ExceptionDTO;
import ar.com.mercadolibre.mundial.dto.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Objects;

@ControllerAdvice
public class ExceptionController {
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<?> handleValidationException(RuntimeException e){
        return new ResponseEntity<>(new ExceptionDTO(e.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<ResponseDTO> handleValidationExceptions(MethodArgumentNotValidException e) {
        ResponseDTO error = new ResponseDTO(Objects.requireNonNull(e.getBindingResult().getFieldError()).getDefaultMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    protected ResponseEntity<ResponseDTO> handleValidationExceptions(HttpMessageNotReadableException e) {
        ResponseDTO error = new ResponseDTO("Formato invalido en la request.");
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
