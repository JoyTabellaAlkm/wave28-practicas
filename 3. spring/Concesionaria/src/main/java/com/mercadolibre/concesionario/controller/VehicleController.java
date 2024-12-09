package com.mercadolibre.concesionario.controller;

import com.mercadolibre.concesionario.dto.VehicleDTO;
import com.mercadolibre.concesionario.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("v1/api/vehicles")
public class VehicleController {
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

    @GetMapping("/prices")
    public ResponseEntity<?> getByPrice(@RequestParam() String since, @RequestParam() String to){
        System.out.println(since);
        System.out.println(to);
        return ResponseEntity.ok(vehicleService.getByPrice(since,to));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getVehicleById(@PathVariable String id){
        return ResponseEntity.ok(vehicleService.getVehicleById(id));
    }

}
