package com.mercadolibre.blog.controller;

import com.mercadolibre.blog.dto.EntradaBlogDto;
import com.mercadolibre.blog.service.IEntradaBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class EntradaBlogController {
    @Autowired
    private IEntradaBlogService entradaBlogService;

    @PostMapping("blog")
    public ResponseEntity<?> postEntradaBlog(@RequestBody EntradaBlogDto entradaBlogDto){
        return new ResponseEntity<>(  entradaBlogService.addEntradaBlog(entradaBlogDto), HttpStatus.CREATED);
    }

    @GetMapping("blogs")
    public ResponseEntity<?> getEntradaBlog(){
        return new ResponseEntity<>(entradaBlogService.getAll(),HttpStatus.OK);
    }

    @GetMapping("blog/{entryId}")
    public ResponseEntity<?> getEntradaBlogById(@PathVariable String entryId){
        return new ResponseEntity<>(entradaBlogService.getById(entryId),HttpStatus.OK);
    }
}
