package com.example.blog.controller;

import com.example.blog.dto.BlogDtoRequest;
import com.example.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class BlogController {
    @Autowired
    private IBlogService servicioBlog;

    @PostMapping("/blog")
    public ResponseEntity<?> crearBlog(@RequestBody BlogDtoRequest nuevoBlog){
        return ResponseEntity.status(HttpStatus.CREATED).body(servicioBlog.agregarBlog(nuevoBlog));
    }

    @GetMapping("blog/{id}")
    public ResponseEntity<?> obtenerblog(@PathVariable Integer id){
        return ResponseEntity.status(HttpStatus.OK).body(servicioBlog.obtenerBlog(id));
    }

    @GetMapping("/blog")
    public ResponseEntity<?> obtenerBlogs(){
        return ResponseEntity.status(HttpStatus.OK).body(servicioBlog.obtenerblogs());
    }


}
