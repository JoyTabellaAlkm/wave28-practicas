package com.example.blog.controller;


import com.example.blog.dto.EntradaBlogDTO;
import com.example.blog.exeption.BlogNotFoundExeption;
import com.example.blog.service.IEntradasBlog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v0.8")
public class EntradaBlogController {
    @Autowired
    private IEntradasBlog entradasBlog;

    @PostMapping("/blog")
    public ResponseEntity<?> createEntradaBlog(@RequestBody EntradaBlogDTO entradaBlogDTO){
        try {
            Optional<EntradaBlogDTO> entrada = entradasBlog.createEntradaBlog(entradaBlogDTO);
            return ResponseEntity.ok(entrada);
        }catch (BlogNotFoundExeption e){
            return ResponseEntity.ok(e.getMessage());
        }
    }

    @GetMapping("/blog/{id}")
    public ResponseEntity<?> getEntradaById(@PathVariable int id){
        try {
            Optional<EntradaBlogDTO> entrada = entradasBlog.getEntradasById(id);
            return ResponseEntity.ok(entrada);
        }catch (BlogNotFoundExeption e){
            return ResponseEntity.ok(e.getMessage());
        }
    }

    @GetMapping("/blogs")
    public ResponseEntity<List<EntradaBlogDTO>> getEntradas(){
        return ResponseEntity.ok(entradasBlog.getEntradas());
    }
}
