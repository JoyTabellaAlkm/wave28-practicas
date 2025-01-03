package com.bootcamp.socialmeli.exception;

import com.bootcamp.socialmeli.dto.ErrorDto;
import com.bootcamp.socialmeli.dto.response.ExceptionDto;
import jakarta.validation.ConstraintViolationException;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class ExceptionController {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> notFound(NotFoundException e) {
        ExceptionDto exceptionDto = new ExceptionDto(e.getMessage());
        return new ResponseEntity<>(exceptionDto, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<?> badRequest(BadRequestException e) {
        ExceptionDto exceptionDto = new ExceptionDto(e.getMessage());
        return new ResponseEntity<>(exceptionDto, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorDto> validationException(MethodArgumentNotValidException e) {
        List<ErrorDto.ErrorDetail> errorDetails = e.getBindingResult().getFieldErrors().stream()
                .map(fieldError -> new ErrorDto.ErrorDetail(
                        fieldError.getField(),
                        fieldError.getDefaultMessage()
                ))
                .collect(Collectors.toList());

        ErrorDto errorDTO = new ErrorDto(errorDetails);
        return ResponseEntity.badRequest().body(errorDTO);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorDto> handleValidationExceptions(HttpMessageNotReadableException e) {
        ErrorDto error = new ErrorDto(List.of(new ErrorDto.ErrorDetail(
                "Invalid input",
                e.getMostSpecificCause().getMessage()
        )));
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

}
