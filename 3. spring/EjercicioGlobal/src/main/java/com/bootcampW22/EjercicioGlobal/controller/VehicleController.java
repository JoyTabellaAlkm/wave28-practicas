package com.bootcampW22.EjercicioGlobal.controller;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.service.IVehicleService;
import com.bootcampW22.EjercicioGlobal.service.VehicleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VehicleController {

    IVehicleService vehicleService;

    @Autowired
    public VehicleController(VehicleServiceImpl vehicleService){
        this.vehicleService = vehicleService;
    }

    @GetMapping("/vehicles")
    public ResponseEntity<?> getVehicles(){
        return new ResponseEntity<>(vehicleService.searchAllVehicles(), HttpStatus.OK);
    }

    @GetMapping("/vehicles/color/{color}/year/{year}")
    public ResponseEntity<?> getVehiclesByColorAndYear(
            @PathVariable String color,
            @PathVariable int year){
        return new ResponseEntity<>(vehicleService.searchAllVehiclesByColorAndYear(color, year), HttpStatus.OK);
    }

    @GetMapping("/vehicles/brand/{brand}/between/{start_year}/{end_year}")
    public ResponseEntity<?> getVehiclesByBrandBetweenDates(
            @PathVariable String brand,
            @PathVariable int start_year,
            @PathVariable int end_year
    ) {
        return ResponseEntity.ok(vehicleService.searchAllVehiclesByBrandBetweenYears(brand, start_year, end_year));
    }

    @GetMapping("/vehicles/average_speed/brand/{brand}")
    public ResponseEntity<?> getAverageSpeedByBrand(
            @PathVariable String brand
    ) {
        return ResponseEntity.ok(vehicleService.findAverageSpeedOfBrand(brand));
    }

    @PostMapping("/vehicles")
    public ResponseEntity<?> createVehicle(@RequestBody VehicleDto vehicleDto) {
        return ResponseEntity.status(201).body(vehicleService.createVehicle(vehicleDto));
    }

    @PostMapping("/vehicles/batch")
    public ResponseEntity<?> createVehicleBatch(@RequestBody List<VehicleDto> vehicleDtoList) {
        return ResponseEntity.status(201).body(vehicleService.createVehicleBatch(vehicleDtoList));
    }
}
