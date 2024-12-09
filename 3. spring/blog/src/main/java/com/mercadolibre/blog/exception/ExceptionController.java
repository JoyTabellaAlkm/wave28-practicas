package com.mercadolibre.blog.exception;

import com.mercadolibre.blog.dto.ExceptionDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {
    @ExceptionHandler(DuplicatedEntryException.class)
    public ResponseEntity<?> duplicatedEntryException(DuplicatedEntryException e){
        ExceptionDto exceptionDto = new ExceptionDto(e.getMessage());
        return  new ResponseEntity<>(exceptionDto, HttpStatus.CONFLICT);
    }
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> notFoundException (NotFoundException e){
        ExceptionDto exceptionDto = new ExceptionDto(e.getMessage());
        return new ResponseEntity<>(exceptionDto,HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(InvalidPathVariableException.class)
    public ResponseEntity<?> invalidPathVariableException(InvalidPathVariableException e){
        ExceptionDto exceptionDto = new ExceptionDto(e.getMessage());
        return new ResponseEntity<>(exceptionDto,HttpStatus.BAD_REQUEST);
    }

}
