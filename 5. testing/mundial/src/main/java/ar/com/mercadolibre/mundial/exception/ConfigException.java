package ar.com.mercadolibre.mundial.exception;

import ar.com.mercadolibre.mundial.dto.ExceptionDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ConfigException {
    @ExceptionHandler(NotFoundJugadorException.class)
    public ResponseEntity<?> notFoundJugadorException(NotFoundJugadorException e){
        ExceptionDTO exceptionDto = new ExceptionDTO(e.getMessage());
        return new ResponseEntity<>(exceptionDto, HttpStatus.NOT_FOUND);
    }
}
