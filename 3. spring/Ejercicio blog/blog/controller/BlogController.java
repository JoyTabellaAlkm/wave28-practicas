package com.example.blog.controller;

import com.example.blog.dto.BlogDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BlogController {
    @Autowired
    private IBlogService blogService;

    @PostMapping("/blog")
    public ResponseEntity<?> createBlog(@RequestBody BlogDTO dto) {
        return new ResponseEntity<>(blogService.create(dto), HttpStatus.CREATED);
    }
}

