package com.mercadolibre.sprint1.exception;

import com.mercadolibre.sprint1.dto.exception.ExceptionDto;
import com.mercadolibre.sprint1.dto.exception.ValidateExceptionDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

	@ExceptionHandler({ PromoSellersNotFoundException.class, NoContentException.class })
	public ResponseEntity<?> promoSellersNotFound(Exception e) {
		return new ResponseEntity<>(new ExceptionDto((e.getMessage())), HttpStatus.NO_CONTENT);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> handleValidationException(MethodArgumentNotValidException ex) {
		List<Map<String, String>> errors = ex.getBindingResult()
				.getFieldErrors()
				.stream()
				.map(error -> {
					Map<String, String> errorDetails = new HashMap<>();
					errorDetails.put("field", error.getField());
					errorDetails.put("message", error.getDefaultMessage());
					return errorDetails;
				})
				.collect(Collectors.toList());

		ValidateExceptionDto responseBody = new ValidateExceptionDto(HttpStatus.BAD_REQUEST.value(), errors);

		return new ResponseEntity<>(responseBody, HttpStatus.BAD_REQUEST);

	}

}
