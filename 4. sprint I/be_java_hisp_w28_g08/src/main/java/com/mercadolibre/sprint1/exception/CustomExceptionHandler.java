package com.mercadolibre.sprint1.exception;

import com.mercadolibre.sprint1.dto.ExceptionDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(annotations = RestController.class)
public class CustomExceptionHandler {

	@ExceptionHandler(BadRequestException.class)
	public ResponseEntity<?> badRequestException(BadRequestException e) {
		return ResponseEntity.badRequest().body(new ExceptionDto((e.getMessage())));
	}

	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<?> notFoundException(NotFoundException e) {
		return new ResponseEntity<>(new ExceptionDto((e.getMessage())), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(PromoSellersNotFoundException.class)
	public ResponseEntity<?> promoSellersNotFound(PromoSellersNotFoundException e) {
		return new ResponseEntity<>(new ExceptionDto((e.getMessage())), HttpStatus.NO_CONTENT);
	}

	@ExceptionHandler(NoContentException.class)
	public ResponseEntity<?> handleNoContentException(NoContentException e) {
		return new ResponseEntity<>(new ExceptionDto((e.getMessage())), HttpStatus.NO_CONTENT);
	}

}
