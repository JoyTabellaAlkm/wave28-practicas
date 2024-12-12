package com.bootcamp.blog.controller;

import com.bootcamp.blog.dto.BlogDto;
import com.bootcamp.blog.service.IBlogService;
import com.bootcamp.blog.service.impl.BlogServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BlogController {
    private final IBlogService service;

    public BlogController(BlogServiceImpl service) {
        this.service = service;
    }

    @PostMapping("/blog")
    public ResponseEntity<?> crearEntradaBlog(@RequestBody BlogDto entradaBlogDto){
        return ResponseEntity.ok().body("Se ha creado con éxito la entrada con id: " + service.create(entradaBlogDto));
    }
}
