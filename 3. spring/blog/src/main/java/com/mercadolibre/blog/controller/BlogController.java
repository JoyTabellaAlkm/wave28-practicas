package com.mercadolibre.blog.controller;

import com.mercadolibre.blog.dto.BlogDto;
import com.mercadolibre.blog.service.IBlogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BlogController {

    private final IBlogService blogService;

    public BlogController(IBlogService blogService) {
        this.blogService = blogService;
    }

    @PostMapping("/blog")
    public ResponseEntity<String> save(@RequestBody BlogDto blog) {
        return new ResponseEntity<>(blogService.save(blog), HttpStatus.CREATED);
    }

    @GetMapping("/blog/{id}")
    public ResponseEntity<BlogDto> findById(@PathVariable Integer id) {
        return new ResponseEntity<>(blogService.findById(id), HttpStatus.OK);
    }

    @GetMapping("/blogs")
    public ResponseEntity<List<BlogDto>> findById() {
        return new ResponseEntity<>(blogService.finadAll(), HttpStatus.OK);
    }
}
