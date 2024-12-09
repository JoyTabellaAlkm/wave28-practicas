package com.bootcamp.ejercicio_blog.controller;

import com.bootcamp.ejercicio_blog.dto.EntradaBlogDto;
import com.bootcamp.ejercicio_blog.service.IEntradaBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BlogController {
    @Autowired
    private IEntradaBlogService entradaBlogService;


    @PostMapping("/blogs")
    public ResponseEntity<?> addNew(@RequestBody EntradaBlogDto entradaBlog){
        EntradaBlogDto createdEntrada = entradaBlogService.addNew(entradaBlog);
        return ResponseEntity.ok("Entrada creada exitosamente: " + createdEntrada.getIdBlog());
    }

    @GetMapping("/blogs")
    public ResponseEntity<?> getAll(){
        List<EntradaBlogDto> entradas = entradaBlogService.getAll();
        return ResponseEntity.ok(entradas);
    }

    @GetMapping("/blog/{id}")
    public ResponseEntity<?> getById(@PathVariable String id){
        EntradaBlogDto entrada = entradaBlogService.getById(id);
        return ResponseEntity.ok(entrada);
    }
}
