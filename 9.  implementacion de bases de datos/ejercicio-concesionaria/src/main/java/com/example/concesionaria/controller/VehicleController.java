package com.example.concesionaria.controller;

import com.example.concesionaria.dto.request.ServiceRequestDTO;
import com.example.concesionaria.dto.request.VehicleRequestDTO;
import com.example.concesionaria.service.IVehicleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {

    IVehicleService vehicleService;

    public VehicleController(IVehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @PostMapping("/create")
    public ResponseEntity<?> createVehicle(@RequestBody VehicleRequestDTO vehicleRequestDTO) {
        return new ResponseEntity<>(vehicleService.createVehicle(vehicleRequestDTO), HttpStatus.CREATED);
    }


    @GetMapping("/repairs/{license}")
    public ResponseEntity<?> getVehicleRepairs(@PathVariable String license) {
        return new ResponseEntity<>(vehicleService.getVehicleRepairs(license), HttpStatus.OK);
    }

    @PostMapping("/repair/{license}")
    public ResponseEntity<?> addVehicleRepair(@PathVariable String license,
                                              @RequestBody ServiceRequestDTO serviceRequestDTO) {
        return new ResponseEntity<>(vehicleService.addRepair(serviceRequestDTO), HttpStatus.CREATED);
    }

}
