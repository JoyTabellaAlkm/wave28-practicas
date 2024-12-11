package com.mercadolibre.ejercicio_global.exception;

import com.mercadolibre.ejercicio_global.dto.ExceptionDto;
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
}
