package com.mercadolibre.youtuveblogs.controller;

import com.mercadolibre.youtuveblogs.dto.EntradaBlogDto;
import com.mercadolibre.youtuveblogs.service.IEntradaBlogService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BlogController {
    private final IEntradaBlogService entradaBlogService;

    public BlogController(IEntradaBlogService entradaBlogService) {
        this.entradaBlogService = entradaBlogService;
    }

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
