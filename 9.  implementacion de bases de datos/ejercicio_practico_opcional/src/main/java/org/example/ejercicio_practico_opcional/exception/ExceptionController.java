package  org.example.ejercicio_practico_opcional.exception;


import org.example.ejercicio_practico_opcional.dto.ExceptionDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

    // Maneja una excepción personalizada para prendas no encontradas
    @ExceptionHandler(PrendaNotFoundException.class)
    public ResponseEntity<ExceptionDTO> handlePrendaNotFound(PrendaNotFoundException e) {
        ExceptionDTO exceptionDTO = new ExceptionDTO(e.getMessage());
        return new ResponseEntity<>(exceptionDTO, HttpStatus.NOT_FOUND);
    }
}