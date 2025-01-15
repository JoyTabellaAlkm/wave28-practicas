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
        return new ResponseEntity<>(vehiculoService.findAllPatentes(), HttpStatus.OK);
    }

    @GetMapping("/allPatentesYMarcasSortedByAnioDeFabricacion")
    ResponseEntity<?> getAllPatentesYMarcasSortedByAnioDeFabricacion() {
        return new ResponseEntity<>(vehiculoService.findByPatentesyMarcasSortedByAnio(), HttpStatus.OK);
    }

    @GetMapping("/allPatentesFilterByFourRuedasAndCurrentAnio")
    ResponseEntity<?> getAllPatentesFilterByFourRuedasAndCurrentAnio() {
        return new ResponseEntity<>(vehiculoService.findByPatenteFilterByFourRuedasAndCurrentAnio(), HttpStatus.OK);
    }

    @GetMapping("/allVehiculosConSiniestroConPerdidaMayorA10000")
    ResponseEntity<?> getAllVehiculosConPerdidaMayorA10000() {
        return new ResponseEntity<>(vehiculoService.findBySiniestroConPerdidaMayorA10000(), HttpStatus.OK);
    }

    @GetMapping("/allVehiculosConSiniestroConPerdidaMayorA10000AndPerdidaTotal")
    ResponseEntity<?> getAllVehiculosConPerdidaMayorA10000AndPerdidaTotal() {
        return new ResponseEntity<>(vehiculoService.findBySiniestroConPerdidaMayorA10000AndPerdidaTotal(), HttpStatus.OK);
    }
}
