package com.bootcamp.concesionariaautos.controller;

import com.bootcamp.concesionariaautos.dto.VehicleDTO;
import com.bootcamp.concesionariaautos.exception.VehicleNotFoundException;
import com.bootcamp.concesionariaautos.service.VehicleService;
import org.apache.coyote.Response;
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
        return ResponseEntity.ok(vehicleService.findById(id));
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody VehicleDTO vehicleDTO) {
        return ResponseEntity.ok(vehicleService.save(vehicleDTO));
    }

    @GetMapping("dates")
    public ResponseEntity<?> findAllByManufacturingDate(
            @RequestParam LocalDate since,
            @RequestParam LocalDate to) {
        return ResponseEntity.ok(vehicleService.findAllByManufacturingDate(since, to));
    }

    @GetMapping("prices")
    public ResponseEntity<?> findAllByPrice(
            @RequestParam BigDecimal since,
            @RequestParam BigDecimal to) {
        return ResponseEntity.ok(vehicleService.findAllByPrice(since, to));
    }

}
