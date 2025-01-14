package com.bootcamp.seguros.controller;

import com.bootcamp.seguros.service.VehiculoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VehiculoController {
    private final VehiculoService vehiculoService;

    public VehiculoController(VehiculoService vehiculoService) {
        this.vehiculoService = vehiculoService;
    }

    @GetMapping("/allPatentes")
    ResponseEntity<?> getAllPatentes() {
        return new ResponseEntity<>(vehiculoService.getAllPatentes(), HttpStatus.OK);
    }

    @GetMapping("/allPatentesYMarcasSortedByAnioDeFabricacion")
    ResponseEntity<?> getAllPatentesYMarcasSortedByAnioDeFabricacion() {
        return new ResponseEntity<>(vehiculoService.getAllPatentesyMarcasSortedByAnioDeFabricacion(), HttpStatus.OK);
    }
}
