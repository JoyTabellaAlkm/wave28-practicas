package com.example.seguros.controller;

import com.example.seguros.service.VehiculoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vehiculos")
public class VehiculosController {
    private final VehiculoService vehiculoService;

    public VehiculosController(VehiculoService vehiculoService) {
        this.vehiculoService = vehiculoService;
    }

    @GetMapping("/patentes")
    public ResponseEntity<?> getAllPatentes() {
        return new ResponseEntity<>(vehiculoService.getAllPatentes(), HttpStatus.OK);
    }

    @GetMapping("/patentes-marcas")
    public ResponseEntity<?> getAllPatentesAndMarcas() {
        return new ResponseEntity<>(vehiculoService.getAllPatenteAndMarcaOrderedByFabricacion(), HttpStatus.OK);
    }

    @GetMapping("/patentes-fabricacion")
    public ResponseEntity<?> getAllPatentesFilterByCantidadRuedasAndFabricacion() {
        return new ResponseEntity<>(vehiculoService.filterPatenteByCantidadRuedasGreaterThanFourAndFabricacion(), HttpStatus.OK);
    }

}
