package com.example.concesionario.controller;

import com.example.concesionario.dto.VehicleDTO;
import com.example.concesionario.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("v1/api/vehicles")
public class VechicleController {
    @Autowired
    private VehicleService vehicleService;

    @PostMapping()
    public ResponseEntity<?> createVehicle(@RequestBody VehicleDTO vehicleDTO){
        System.out.println(vehicleDTO.toString());
        return ResponseEntity.ok(vehicleService.createVehicle(vehicleDTO));
    }
    @GetMapping()
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(vehicleService.getAll());
    }
    @GetMapping("/dates")
    public ResponseEntity<?> getByDate(@RequestParam() LocalDate since, @RequestParam() LocalDate to){
        System.out.println(since);
        System.out.println(to);
        return ResponseEntity.ok(vehicleService.getByDate(since,to));
    }
}
