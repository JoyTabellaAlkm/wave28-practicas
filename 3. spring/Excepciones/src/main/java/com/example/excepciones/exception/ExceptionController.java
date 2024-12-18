package com.example.excepciones.exception;

import com.example.excepciones.dto.ExceptionDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice(annotations = Controller.class)
public class ExceptionController {

    @ExceptionHandler(AlreadyExistsException.class)
    ResponseEntity<?> alreadyExistException( AlreadyExistsException e){
        ExceptionDTO  exceptionDTO = new ExceptionDTO(e.getMessage());

        return  new ResponseEntity<>(exceptionDTO, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(NotFoundException.class)
    ResponseEntity<?> notFoundException(NotFoundException e){
        ExceptionDTO exceptionDTO = new ExceptionDTO(e.getMessage());
        return  new ResponseEntity<>(exceptionDTO, HttpStatus.NOT_FOUND);
    }

}
