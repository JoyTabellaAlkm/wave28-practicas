package com.meli.be_java_hisp_w28_g01.exception;

import com.meli.be_java_hisp_w28_g01.dto.ExceptionDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ExceptionDto> notFound(NotFoundException e) {
        ExceptionDto exceptionDto = new ExceptionDto(e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exceptionDto);
    }

    @ExceptionHandler(AlreadyExistsException.class)
    public ResponseEntity<ExceptionDto> alreadyExists(AlreadyExistsException e) {
        ExceptionDto exceptionDto = new ExceptionDto(e.getMessage());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(exceptionDto);

    }
    @ExceptionHandler(FollowAlreadyExistsException.class)
    public ResponseEntity<ExceptionDto> followAlreadyExists(FollowAlreadyExistsException e) {
        ExceptionDto exceptionDto = new ExceptionDto(e.getMessage());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(exceptionDto);

    }
    @ExceptionHandler(IsEmptyException.class)
    public ResponseEntity<ExceptionDto> isEmpty(IsEmptyException e) {
        ExceptionDto exceptionDto = new ExceptionDto(e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exceptionDto);

    }
    @ExceptionHandler(IlegalArgumentException.class)
    public ResponseEntity<ExceptionDto> ilegalArgument(IlegalArgumentException e){
        ExceptionDto exceptionDto = new ExceptionDto(e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exceptionDto);
    }
    @ExceptionHandler(FollowNotFoundException.class)
    public ResponseEntity<ExceptionDto> followNotFound(FollowNotFoundException e){
        ExceptionDto exceptionDto = new ExceptionDto(e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exceptionDto);
    }

    //excepción para manejar validaciones de atributos en los dto de los requestbody
    @ExceptionHandler(IllegalStateException.class)
    public ResponseEntity<String> handleValidation(IllegalStateException ex) {
        String error = ex.getLocalizedMessage();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }
}
