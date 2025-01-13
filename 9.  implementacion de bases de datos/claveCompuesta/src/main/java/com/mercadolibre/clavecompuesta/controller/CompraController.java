package com.mercadolibre.clavecompuesta.controller;

import com.mercadolibre.clavecompuesta.dto.CompraDto;
import com.mercadolibre.clavecompuesta.service.ICompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CompraController {
    @Autowired
    ICompraService compraService;

    @PostMapping("/compra/new")
    public ResponseEntity<String> nuevaCompra(@RequestBody CompraDto compraDto){
        compraService.nuevaCompra(compraDto);
        return ResponseEntity.ok("Compra realizada");
    }

    @GetMapping("/compra")
    public ResponseEntity<List<CompraDto>> obtenerCompras(){
        return ResponseEntity.ok(compraService.obtenerCompras());
    }
}
