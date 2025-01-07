package com.bootcamp.socialmeli.exception;

import com.bootcamp.socialmeli.dto.response.ErrorDto;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.context.MessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.method.ParameterValidationResult;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.HandlerMethodValidationException;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.util.Collection;

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

    @ExceptionHandler(UserNotFollowedException.class)
    public ResponseEntity<ErrorDto> UserNotFollowedException(UserNotFollowedException e){
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(
                new ErrorDto(HttpStatus.FORBIDDEN.value(),e.getMessage()));

    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<ErrorDto> methodNotSupportedHandler(HttpRequestMethodNotSupportedException ex) {
        String msg = "Method not supported: " + ex.getLocalizedMessage();
        return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).body(
                new ErrorDto(HttpStatus.METHOD_NOT_ALLOWED.value(), msg));
    }

    @ExceptionHandler(HandlerMethodValidationException.class)
    public ResponseEntity<ErrorDto> handlerMethodValidationHandler(HandlerMethodValidationException ex){
        String msg = ex.getParameterValidationResults().stream()
                .map(ParameterValidationResult::getResolvableErrors)
                .flatMap(Collection::stream)
                .findFirst()
                .map(MessageSourceResolvable::getDefaultMessage)
                .orElse("Unknown validation error");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                new ErrorDto(HttpStatus.BAD_REQUEST.value(), msg)
        );
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErrorDto> constraintViolationHandler(ConstraintViolationException ex){
        String msg = ex.getConstraintViolations().stream()
                .findFirst()
                .map(ConstraintViolation::getMessage)
                .orElse("Unknown validation error");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                new ErrorDto(HttpStatus.BAD_REQUEST.value(), msg)
        );
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorDto> methodArgumentNotValidException (MethodArgumentNotValidException ex)
    {
        ErrorDto errorDto = new ErrorDto();
        errorDto.setStatus(HttpStatus.BAD_REQUEST.value());
        errorDto.setMessage(ex.getBindingResult().getFieldErrors().get(0).getDefaultMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorDto);
    }

    @ExceptionHandler({MissingRequestHeaderException.class,
            HttpMessageNotReadableException.class,
            MethodArgumentTypeMismatchException.class,
            IllegalArgumentException.class,
            OrderInvalidException.class,
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

    // Handler para excepciones que no poseen handlers definidos
    @ExceptionHandler(Exception.class)
    protected ResponseEntity<ErrorDto> unknownExceptionHandler(Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                new ErrorDto(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage()));
    }
}
