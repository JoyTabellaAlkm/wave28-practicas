package com.bootcamp.relaciones.controller;

import com.bootcamp.relaciones.dto.LibroDto;
import com.bootcamp.relaciones.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/libros")
public class LibroController {

    @Autowired
    LibroService libroService;

    @PostMapping("/")
    ResponseEntity<Void> crearLibroConTodo(@RequestBody LibroDto libroDto) {
        libroService.creaTodo(libroDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
