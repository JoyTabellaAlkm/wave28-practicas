package com.bootcamp.linktracker.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Link no encontrado")
public class LinkNoEncontradoException extends RuntimeException {
}
