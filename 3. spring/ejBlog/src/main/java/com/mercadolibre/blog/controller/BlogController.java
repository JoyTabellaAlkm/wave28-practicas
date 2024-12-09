package com.mercadolibre.blog.controller;

import com.mercadolibre.blog.dto.BlogDTO;
import com.mercadolibre.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
