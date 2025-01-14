package com.example.concesionaria.controller;

import com.example.concesionaria.dto.request.ServiceRequestDTO;
import com.example.concesionaria.service.IVehicleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/services")
public class ServiceController {

    IVehicleService vehicleService;

    public ServiceController(IVehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @PostMapping("/create/car/{id}")
    public ResponseEntity<?> createService(@PathVariable Long id,
                                           @RequestBody ServiceRequestDTO) {

    }

}
