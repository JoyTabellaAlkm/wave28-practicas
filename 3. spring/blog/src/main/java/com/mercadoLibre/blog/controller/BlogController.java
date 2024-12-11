package com.mercadoLibre.blog.controller;

import com.mercadoLibre.blog.dto.BlogDTO;
import com.mercadoLibre.blog.service.IBlogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class BlogController {
    final IBlogService blogService;

    public BlogController(IBlogService blogService) {
        this.blogService = blogService;
    }

    @PostMapping("/blog")
    public ResponseEntity<?> agregarNuevoBlog (@RequestBody BlogDTO blogAAgregar){
        return new ResponseEntity<>(blogService.agregarBlog(blogAAgregar), HttpStatus.CREATED);
    }

    @GetMapping("/blog/{id}")
    public ResponseEntity<?> mostrarBlogPorId (@PathVariable long id){
        return new ResponseEntity<>(blogService.buscarBlogPorId(id), HttpStatus.OK);
    }

    @GetMapping("/blogs")
    public ResponseEntity<?> mostrarTodosBlogs (){
        return new ResponseEntity<>(blogService.traerTodosBlogs(), HttpStatus.OK);
    }
}
