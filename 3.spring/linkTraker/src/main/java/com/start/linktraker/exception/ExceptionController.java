package com.start.linktraker.exception;

import com.start.linktraker.dto.ExceptionDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<?> badRequest(BadRequestException e){

        ExceptionDto exceptionDto= new ExceptionDto(e.getMessage());
        return  new ResponseEntity<>(exceptionDto, HttpStatus.BAD_REQUEST);

    }

}
