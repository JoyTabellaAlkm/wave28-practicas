package com.example.blogyoutube.controller;

import com.example.blogyoutube.dto.EntradaBlogDto;
import com.example.blogyoutube.service.IEntradaBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class EntradaBlogController {

    @Autowired
    IEntradaBlogService entradaBlogService;

    @GetMapping("/blogs")
    public ResponseEntity<?> getEntradaBlogs(){
        return new ResponseEntity<>(entradaBlogService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/blogs")
    public ResponseEntity<?> createEntradaBlog(@RequestBody EntradaBlogDto entradaBlogDto) {
        return new ResponseEntity<>(entradaBlogService.createEntradaBlog(entradaBlogDto), HttpStatus.CREATED);
    }

    @GetMapping("/blogs/{id}")
    public ResponseEntity<?> getEntradaBlog(@PathVariable long id) {
        return new ResponseEntity<>(entradaBlogService.find(id), HttpStatus.OK);
    }
}
