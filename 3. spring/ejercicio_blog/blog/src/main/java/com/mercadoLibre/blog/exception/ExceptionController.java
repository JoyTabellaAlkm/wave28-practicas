package com.mercadoLibre.blog.exception;

import com.mercadoLibre.blog.dto.ExceptionDTO;
import com.mercadoLibre.blog.exception.customizedExceptions.AlreadyExistsException;
import com.mercadoLibre.blog.exception.customizedExceptions.NoContentException;
import com.mercadoLibre.blog.exception.customizedExceptions.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

//    @ExceptionHandler(NotFoundException.class)
//    public ResponseEntity<?> notFound(NotFoundException e){
//        return new ResponseEntity<>(
//                new ExceptionDTO(e.getMessage()),
//                HttpStatus.NOT_FOUND);
//    }
//
//    @ExceptionHandler(AlreadyExistsException.class)
//    public ResponseEntity<?> alreadyExist(AlreadyExistsException e){
//        return new ResponseEntity<>(
//                new ExceptionDTO(e.getMessage()),
//                HttpStatus.CONFLICT);
//    }
//
//    @ExceptionHandler(NoContentException.class)
//    public ResponseEntity<?> noContent(){
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }
}
