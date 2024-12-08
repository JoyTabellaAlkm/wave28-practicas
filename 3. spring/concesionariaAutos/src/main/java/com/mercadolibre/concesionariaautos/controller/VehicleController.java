package com.mercadolibre.concesionariaautos.controller;

import com.mercadolibre.concesionariaautos.dto.VehicleDTO;
import com.mercadolibre.concesionariaautos.service.IVehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/v1/api/vehicles")
public class VehicleController {

    @Autowired
    private IVehicleService vehicleService;

    @PostMapping("")
    public ResponseEntity<?> createVehicle(@RequestBody VehicleDTO dto) {
        return new ResponseEntity<>(vehicleService.create(dto), HttpStatus.CREATED);
    }

    @GetMapping("")
    public ResponseEntity<?> getAllVehicles() {
        return new ResponseEntity<>(vehicleService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/dates")
    public ResponseEntity<?> getVehiclesBetweenDate(@RequestParam LocalDate since, @RequestParam LocalDate to) {
        return new ResponseEntity<>(vehicleService.getVehiclesBetweenDates(since,to), HttpStatus.OK);
    }

    @GetMapping("/prices")
    public ResponseEntity<?> getVehiclesBetweenPrices(@RequestParam Double since, @RequestParam Double to) {
        return new ResponseEntity<>(vehicleService.getVehiclesBetweenPrices(since,to), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getVehicleById(@PathVariable Integer id) {
        return new ResponseEntity<>(vehicleService.getVehiclesById(id), HttpStatus.OK);
    }

}
