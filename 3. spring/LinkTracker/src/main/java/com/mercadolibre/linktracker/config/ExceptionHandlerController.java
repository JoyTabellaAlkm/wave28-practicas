package com.mercadolibre.linktracker.config;

import com.mercadolibre.linktracker.exceptions.InactiveResourceException;
import com.mercadolibre.linktracker.exceptions.InvalidURLException;
import com.mercadolibre.linktracker.exceptions.LinkNotFoundException;
import com.mercadolibre.linktracker.exceptions.MissingAttributesException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice(annotations = RestController.class)
public class ExceptionHandlerController {

    @ExceptionHandler(InvalidURLException.class)
    public ResponseEntity<?> invalidURLException(Exception e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

    @ExceptionHandler(LinkNotFoundException.class)
    public ResponseEntity<?> linkNotFoundException(Exception e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }

    @ExceptionHandler(MissingAttributesException.class)
    public ResponseEntity<?> missingAttributesException(Exception e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

    @ExceptionHandler(InactiveResourceException.class)
    public ResponseEntity<?> inactiveResourceException(Exception e){
        return ResponseEntity.status(HttpStatus.GONE).body(e.getMessage());
    }

}
