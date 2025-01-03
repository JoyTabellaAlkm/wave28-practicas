package com.spring1.meliSocial.exception;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.spring1.meliSocial.dto.ExceptionDto;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.format.DateTimeParseException;

@ControllerAdvice
public class ExceptionController {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> notFound(NotFoundException e){
        ExceptionDto exceptionDto = new ExceptionDto(e.getMessage());
        return new ResponseEntity<>(exceptionDto, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<?> badRequest(BadRequestException e){
        ExceptionDto exceptionDto = new ExceptionDto(e.getMessage());
        return new ResponseEntity<>(exceptionDto, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ExistingDataException.class)
    public ResponseEntity<?> existingData(ExistingDataException e){
        ExceptionDto exceptionDto = new ExceptionDto(e.getMessage());
        return new ResponseEntity<>(exceptionDto, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(NotSellerException.class)
    public ResponseEntity<?> notSeller(NotSellerException e){
        ExceptionDto exceptionDto = new ExceptionDto(e.getMessage());
        return new ResponseEntity<>(exceptionDto, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InternalServerErrorException.class)
    public ResponseEntity<?> internalServerError(InternalServerErrorException e){
        ExceptionDto exceptionDto = new ExceptionDto(e.getMessage());
        return new ResponseEntity<>(exceptionDto, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<?> handleValidationExceptions(MethodArgumentNotValidException e) {
        ExceptionDto errorDTO = new ExceptionDto(
                e.getAllErrors().stream()
                        .map(DefaultMessageSourceResolvable::getDefaultMessage)
                        .toList().toString());

        errorDTO.setMessage( errorDTO.getMessage().substring(1, errorDTO.getMessage().length() - 1));
        return ResponseEntity.badRequest().body(errorDTO);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    protected ResponseEntity<?> handleValidationExceptions(HttpMessageNotReadableException e) {
        ExceptionDto error = new ExceptionDto();

        if(e.getCause() instanceof InvalidFormatException) {
            if(e.getCause().getCause() instanceof DateTimeParseException) {
                error = new ExceptionDto("Ingrese un formato válido de fecha como dd-MM-YYYY");
            }
        } else {
            error = new ExceptionDto("Formato invalido en la request.");
        }

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

}
