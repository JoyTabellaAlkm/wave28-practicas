package com.mercadolibre.siniestros.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mercadolibre.siniestros.dto.CreateVehicleDto;
import com.mercadolibre.siniestros.service.IVehiculoService;

@RestController
@RequestMapping("/vehiculos")
public class VehiculoController {

    @Autowired
    private IVehiculoService vehiculoService;

    @GetMapping
    public ResponseEntity<?> findAllVehiculos() {
        return ResponseEntity.ok(vehiculoService.findAllVehiculos());
    }

    @PostMapping
    public ResponseEntity<?> saveVehiculo(@RequestBody CreateVehicleDto request) {
        return ResponseEntity.ok(vehiculoService.saveVehiculo(request));
    }

    @GetMapping("/patentes")
    public ResponseEntity<?> findAllPatentes() {
        return ResponseEntity.ok(vehiculoService.findAllPatentes());
    }

    @GetMapping("/patentes-marcas")
    public ResponseEntity<?> findAllPatentesAndMarcasOrderByAnioFabricacion() {
        return ResponseEntity.ok(vehiculoService.findAllPatentesAndMarcasOrderByAnioFabricacion());
    }

    @GetMapping("/patentes/ruedas/{cantidadRuedas}")
    public ResponseEntity<?> findAllPatentesByCantidadRuedasUp(@PathVariable int cantidadRuedas) {
        int currentYear = LocalDate.now().getYear();
        return ResponseEntity.ok(vehiculoService.findAllPatentesByCantidadRuedasUpAndAnioFabricacionIs(cantidadRuedas, currentYear));
    }

}
