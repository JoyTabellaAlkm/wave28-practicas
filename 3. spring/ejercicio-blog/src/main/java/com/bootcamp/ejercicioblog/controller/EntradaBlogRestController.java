package com.bootcamp.ejercicioblog.controller;

import com.bootcamp.ejercicioblog.model.EntradaBlog;
import com.bootcamp.ejercicioblog.service.IEntradaBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("blog")
public class EntradaBlogRestController {
    @Autowired
    IEntradaBlogService entradaBlogService;

    @PostMapping
    public ResponseEntity<?> crearEntrada(@RequestBody EntradaBlog entradaBlog) {
        return new ResponseEntity<>(entradaBlogService.crearEntradaBlog(entradaBlog), HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<?> obtenerEntradaPorId(@PathVariable Long id) {
        return new ResponseEntity<>(entradaBlogService.obtenerEntradaPorId(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> obtenerEntradas() {
        return new ResponseEntity<>(entradaBlogService.obtenerEntradas(), HttpStatus.OK);
    }
}
