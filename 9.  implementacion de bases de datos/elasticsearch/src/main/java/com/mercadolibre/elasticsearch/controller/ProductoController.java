package com.mercadolibre.elasticsearch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mercadolibre.elasticsearch.dto.CreateProductoDto;
import com.mercadolibre.elasticsearch.entity.Producto;
import com.mercadolibre.elasticsearch.service.IProductoService;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private IProductoService productoService;

    @GetMapping
    public Iterable<?> findAll() {
        return productoService.findAll();
    }

    @PostMapping
    public Producto save(@RequestBody CreateProductoDto request) {
        return productoService.save(request);
    }

}
