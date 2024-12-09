package com.mercadolibre.Blog.controller;

import com.mercadolibre.Blog.dto.BlogDTO;
import com.mercadolibre.Blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BlogController {
    @Autowired
    IBlogService service;

    @GetMapping("/blog")
    public ResponseEntity<List<BlogDTO>> listarTodos(){
        return new ResponseEntity<List<BlogDTO>>(service.listarTodas(), HttpStatus.ACCEPTED);
    }
    @GetMapping("/blog/{id}")
    public ResponseEntity<BlogDTO> filtrarPorId(@PathVariable int id){
        return new ResponseEntity<BlogDTO>(service.filterById(id), HttpStatus.ACCEPTED);
    }
    @PostMapping("/blog")
    public ResponseEntity<BlogDTO> registrarBlog(@RequestBody BlogDTO blog){
        return new ResponseEntity<BlogDTO>(service.agregarEntrada(blog),HttpStatus.CREATED);
    }
}
