package com.bootcamp.concesionariaautos.controller;

import com.bootcamp.concesionariaautos.dto.VehicleDTO;
import com.bootcamp.concesionariaautos.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.DateTimeException;
import java.time.LocalDate;

@RestController
@RequestMapping("v1/api/vehicles")
public class VehicleRestController {

    @Autowired
    private VehicleService vehicleService;

    @GetMapping
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(vehicleService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        VehicleDTO vehicleDTO = vehicleService.findById(id);
        if(vehicleDTO != null) {
            return ResponseEntity.ok(vehicleService.findById(id));
        }
        return ResponseEntity.status(404).body("Vehicle not found");
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody VehicleDTO vehicleDTO) {
        return ResponseEntity.ok(vehicleService.save(vehicleDTO));
    }

    @GetMapping("dates")
    public ResponseEntity<?> findAllByManufacturingDate(
            @RequestParam LocalDate since,
            @RequestParam LocalDate to) {
        try {
            return ResponseEntity.ok(vehicleService.findAllByManufacturingDate(since, to));
        } catch (DateTimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("prices")
    public ResponseEntity<?> findAllByPrice(
            @RequestParam BigDecimal since,
            @RequestParam BigDecimal to) {
        try {
            return ResponseEntity.ok(vehicleService.findAllByPrice(since, to));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
