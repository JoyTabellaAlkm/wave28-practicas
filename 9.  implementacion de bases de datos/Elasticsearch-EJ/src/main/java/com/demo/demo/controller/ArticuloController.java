package com.demo.demo.controller;

import com.demo.demo.domain.Articulo;
import com.demo.demo.repository.ArticuloRepository;
import org.springframework.data.util.Streamable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/articulos")
public class ArticuloController {
    private final ArticuloRepository repository;

    public ArticuloController(ArticuloRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public Articulo create(@RequestBody Articulo articulo) {
        return repository.save(articulo);
    }

    @GetMapping
    public Iterable<Articulo> findAll() {
        return repository.findAll();
    }
}
