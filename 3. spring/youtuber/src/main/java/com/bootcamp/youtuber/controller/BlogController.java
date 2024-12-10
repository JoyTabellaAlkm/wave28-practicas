package com.bootcamp.youtuber.controller;

import com.bootcamp.youtuber.dto.EntradaBlogDto;
import com.bootcamp.youtuber.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BlogController {

    @Autowired
    private BlogService blogService;

    @PostMapping("/blog")
    public ResponseEntity<String> createBlog(@RequestBody EntradaBlogDto entradaBlog) {
        blogService.create(entradaBlog);
        return ResponseEntity.status(HttpStatus.CREATED).body(String.format("Entrada con id: %d creada correctamente", entradaBlog.getId()));
    }

    @GetMapping("/blog/{id}")
    public ResponseEntity<EntradaBlogDto> getBlog(@PathVariable Long id) {
        return ResponseEntity.ok(blogService.getBlogBy(id));
    }

    @GetMapping("/blogs")
    public ResponseEntity<List<EntradaBlogDto>> getAllBlogs() {
        return ResponseEntity.ok(blogService.getAllBlogs());
    }

}
