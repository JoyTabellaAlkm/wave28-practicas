package com.bootcamp.socialmeli.exception;

import com.bootcamp.socialmeli.dto.response.ErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorDto> notFoundHandler(NotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new ErrorDto(HttpStatus.NOT_FOUND.value(), e.getMessage()));
    }

    @ExceptionHandler (IdProductConflictException.class)
    public ResponseEntity<ErrorDto> idProductConflictException(IdProductConflictException e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                new ErrorDto(HttpStatus.BAD_REQUEST.value(), e.getMessage()));
    }
    @ExceptionHandler(ExistingFollowException.class)
    public ResponseEntity<ErrorDto> existingFollowHandler(ExistingFollowException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                new ErrorDto(HttpStatus.BAD_REQUEST.value(), e.getMessage()));
    }
    @ExceptionHandler(IllegalFollowException.class)
    public ResponseEntity<ErrorDto> illegalFollowHandler(IllegalFollowException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                new ErrorDto(HttpStatus.BAD_REQUEST.value(), e.getMessage()));
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<ErrorDto> methodNotSupportedHandler(HttpRequestMethodNotSupportedException ex) {
        String msg = "Method not supported: " + ex.getLocalizedMessage();
        return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).body(
                new ErrorDto(HttpStatus.METHOD_NOT_ALLOWED.value(), msg));
    }

    @ExceptionHandler({MissingRequestHeaderException.class,
            MethodArgumentNotValidException.class,
            HttpMessageNotReadableException.class,
            MethodArgumentTypeMismatchException.class,
            IllegalArgumentException.class,
            OrderValidException.class,
            BadRequestException.class})
    public ResponseEntity<ErrorDto> badRequestHandler(Exception ex) {
        String msg = "Bad request: " + ex.getLocalizedMessage();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                new ErrorDto(HttpStatus.BAD_REQUEST.value(), msg));
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<ErrorDto> noHandlerFoundHandler(NoHandlerFoundException ex) {
        String msg = String.format("Route %s not found", ex.getRequestURL());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new ErrorDto(HttpStatus.NOT_FOUND.value(), msg));
    }
    @ExceptionHandler(UserNotFollowedException.class)
    public ResponseEntity<ErrorDto> UserNotFollowedException(UserNotFollowedException e){
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(
                new ErrorDto(HttpStatus.FORBIDDEN.value(),e.getMessage()));

    }

    // Handler para excepciones que no poseen handlers definidos
    @ExceptionHandler(Exception.class)
    protected ResponseEntity<ErrorDto> unknownExceptionHandler(Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                new ErrorDto(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage()));
    }
}
