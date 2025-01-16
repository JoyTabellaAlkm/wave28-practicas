package com.mercadolibre.ejercicioextrashowroom.exception;

import com.mercadolibre.ejercicioextrashowroom.dto.response.MessageDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> notFoundException(Exception e) {
        return new ResponseEntity<>(new MessageDTO(e.getMessage()), HttpStatus.NOT_FOUND);
    }

}
