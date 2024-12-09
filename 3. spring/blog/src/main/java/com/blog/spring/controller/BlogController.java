package com.blog.spring.controller;

import com.blog.spring.dto.EntradaBlogDTO;
import com.blog.spring.service.iBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BlogController {
    
    @Autowired
    private iBlogService servicio;

    @PostMapping("/blog")
    public ResponseEntity<EntradaBlogDTO> createBlog(@RequestBody EntradaBlogDTO blog) {
        return new ResponseEntity<>(servicio.createBlog(blog), HttpStatus.CREATED);
    }

    @GetMapping("/blog/{id}")
    public ResponseEntity<?> findEntrada(@PathVariable int id) {
        return new ResponseEntity<>(servicio.findByID(id), HttpStatus.OK);
    }

    @GetMapping("/blogs")
    public ResponseEntity<List<EntradaBlogDTO>> getEntradas() {
        return ResponseEntity.ok(servicio.findAllEntradas());
    }
}
