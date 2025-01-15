package com.mercadolibre.llavecompuesta.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mercadolibre.llavecompuesta.dto.CreateCompraDto;
import com.mercadolibre.llavecompuesta.service.ICompraService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/compras")
public class ComprasController {

    @Autowired
    private ICompraService compraService;

    @PostMapping
    public ResponseEntity<?> saveCompra(@RequestBody CreateCompraDto request) {
        return ResponseEntity.ok(compraService.save(request));
    }

    @GetMapping
    public ResponseEntity<?> findAllCompras() {
        return ResponseEntity.ok(compraService.findAll());
    }
    

}
