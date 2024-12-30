package com.bootcampW22.EjercicioGlobal.exception;

import com.bootcampW22.EjercicioGlobal.dto.ExceptionDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> notFound(NotFoundException e) {
        ExceptionDto exceptionDto = new ExceptionDto(e.getMessage());
        return new ResponseEntity<>(exceptionDto, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Conflict.class)
    public ResponseEntity<?> conflict(Conflict e) {
        ExceptionDto exceptionDto = new ExceptionDto(e.getMessage());
        return new ResponseEntity<>(exceptionDto, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(BadRequest.class)
    public ResponseEntity<?> badRequest(BadRequest e) {
        ExceptionDto exceptionDto = new ExceptionDto(e.getMessage());
        return new ResponseEntity<>(exceptionDto, HttpStatus.BAD_REQUEST);
    }

}
