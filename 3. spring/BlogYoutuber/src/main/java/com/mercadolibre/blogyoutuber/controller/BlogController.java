package com.mercadolibre.blogyoutuber.controller;

import com.mercadolibre.blogyoutuber.dto.BlogDTO;
import com.mercadolibre.blogyoutuber.service.IBlog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
public class BlogController {

    @Autowired
    private IBlog blogService;

    @PostMapping("/blog")
    public ResponseEntity<?> create(@RequestBody BlogDTO blogDto){
        return new ResponseEntity<>(blogService.crearEntrada(blogDto), HttpStatus.CREATED);
    }

    @GetMapping("/blog/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        return new ResponseEntity<>(blogService.obtenerBlogPorId(id), HttpStatus.OK);
    }

    @GetMapping("/blog")
    public ResponseEntity<?> getAll() {
        HashMap<Long, BlogDTO> blogs = blogService.obtenerBlogs();
        return ResponseEntity.ok(blogs);
    }

}
