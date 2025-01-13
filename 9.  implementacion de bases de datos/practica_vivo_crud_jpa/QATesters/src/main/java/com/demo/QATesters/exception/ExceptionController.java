package com.demo.QATesters.exception;

import com.demo.QATesters.dto.MessageDto;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> notFound(NotFoundException e){
        MessageDto dto = new MessageDto(e.getMessage());
        return new ResponseEntity<>(dto, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<MessageDto> validationException(MethodArgumentNotValidException e){

        MessageDto dto = new MessageDto("Se encontraron los siguientes errores en las validaciones: @Valid del DTO" +
                e.getAllErrors().stream()
                        .map(DefaultMessageSourceResolvable::getDefaultMessage)
                        .toList());

        return ResponseEntity.badRequest().body(dto);
    }
}
