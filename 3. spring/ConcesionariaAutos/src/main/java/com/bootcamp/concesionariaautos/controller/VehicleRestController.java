package com.bootcamp.concesionariaautos.controller;

import com.bootcamp.concesionariaautos.service.VehicleService;
import com.bootcamp.concesionariaautos.service.VehicleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/api/vehicles")
public class VehicleRestController {

    @Autowired
    private VehicleService vehicleService;

    @GetMapping
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(vehicleService.findAll());
    }

}
