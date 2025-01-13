package com.bootcamp.ejercicio_concesionaria.controller;

import com.bootcamp.ejercicio_concesionaria.dto.VehicleAllDto;
import com.bootcamp.ejercicio_concesionaria.dto.VehicleNoServiceDto;
import com.bootcamp.ejercicio_concesionaria.service.IVehicleService;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/v1/api/vehicles")
public class VehiclesController {

    @Autowired
    IVehicleService vehicleService;

    @PostMapping("")
    public ResponseEntity<?> addVehicle(@RequestBody VehicleAllDto vehicle) {
        if (vehicle == null) {
            return ResponseEntity.badRequest().body("Request cannot be null");
        }
        Long id = vehicleService.addCar(vehicle);
        return ResponseEntity.ok(id);
    }

    @GetMapping
    public ResponseEntity<List<VehicleNoServiceDto>> getCars(){
        return ResponseEntity.ok(vehicleService.getAll());
    }

    @GetMapping("/dates")
    public ResponseEntity<List<VehicleNoServiceDto>> getVehicleBetweenDates(
            @RequestParam @JsonFormat(pattern = "yyyy-MM-dd") String since,
            @RequestParam @JsonFormat(pattern = "yyyy-MM-dd") String to
    ){
        return ResponseEntity.ok(vehicleService.getVehicleDates(since, to));
    }

    @GetMapping("prices")
    public ResponseEntity<List<VehicleNoServiceDto>> getVehicleBetweenPrices(
            @RequestParam Double since,
            @RequestParam Double to){
        return ResponseEntity.ok(vehicleService.getBetweenPrices(since, to));
    }

    @GetMapping("{id}")
    public ResponseEntity<VehicleAllDto>  getVehicleById(@PathVariable Long id){
        return ResponseEntity.ok(vehicleService.getById(id));
    }
}
