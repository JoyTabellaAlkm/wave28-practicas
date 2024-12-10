package com.bootcamp.linktracker.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Password invalida")
public class PasswordInvalidaException extends RuntimeException {
}
