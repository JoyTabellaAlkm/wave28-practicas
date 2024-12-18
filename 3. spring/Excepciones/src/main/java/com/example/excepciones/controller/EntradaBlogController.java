package com.example.excepciones.controller;

import com.example.excepciones.dto.EntradaBlogDTO;
import com.example.excepciones.service.IEntradaBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/blog")
public class EntradaBlogController {

    @Autowired
    IEntradaBlogService entradaBlogService;

    @PostMapping()
    public ResponseEntity<?> crearBlog(@RequestBody EntradaBlogDTO blog){
       return new ResponseEntity<>(entradaBlogService.crearEntradaBlog(blog), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public  ResponseEntity<?> obtenerBlogPorId(@PathVariable Long id){
        return  new ResponseEntity<>(entradaBlogService.obtenerBlogPorId(id), HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<?> obtenerBlogs(){
        return  new ResponseEntity<>(entradaBlogService.obtenerBlogs(), HttpStatus.OK);
    }
}
