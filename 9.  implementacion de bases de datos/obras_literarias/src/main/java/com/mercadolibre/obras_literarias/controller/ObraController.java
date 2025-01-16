package com.mercadolibre.obras_literarias.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mercadolibre.obras_literarias.dto.CreateObraDto;
import com.mercadolibre.obras_literarias.entity.Obra;
import com.mercadolibre.obras_literarias.service.IObraService;

@RestController
@RequestMapping("/obras")
public class ObraController {

    @Autowired
    private IObraService obraService;

    @GetMapping
    public Iterable<Obra> findAll() {
        return obraService.findAll();
    }

    @PostMapping
    public Obra save(@RequestBody CreateObraDto obra) {
        return obraService.save(obra);
    }

    @GetMapping("/search/{query}")
    public Iterable<Obra> search(@PathVariable String query) {
        return obraService.findAllByEditorial(query);
    }

}
