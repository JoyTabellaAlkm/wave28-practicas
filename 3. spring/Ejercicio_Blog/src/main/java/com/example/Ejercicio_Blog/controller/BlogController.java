package com.example.Ejercicio_Blog.controller;

import com.example.Ejercicio_Blog.dto.EntradaBlogDto;
import com.example.Ejercicio_Blog.service.IBlogService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/blog")
public class BlogController {

    private final IBlogService service;

    public BlogController(IBlogService service) {
        this.service = service;
    }

    @PostMapping()
    public ResponseEntity<?> crearEntradaBlog(@RequestBody EntradaBlogDto entradaBlogDto){
        return ResponseEntity.ok().body("Se ha creado con éxito la entrada con id: " + service.create(entradaBlogDto));
    }
}
