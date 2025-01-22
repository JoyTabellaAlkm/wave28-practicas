package com.bootcampW22.EjercicioGlobal.controller;

import com.bootcampW22.EjercicioGlobal.dto.ExceptionDto;
import com.bootcampW22.EjercicioGlobal.dto.VehicleCreateDto;
import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.service.IVehicleService;
import com.bootcampW22.EjercicioGlobal.service.VehicleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Provider;

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

    @PostMapping("/vehicles")
    public ResponseEntity<?> addVehicle(@RequestBody VehicleDto vehicleDto) {
        vehicleService.addVehicle(vehicleDto);
        // Ejercicio #1
        return ResponseEntity.status(HttpStatus.CREATED).body("Vehículo creado exitosamente.");
    }

    //ejercicio #2
    @GetMapping("/vehicles/color/{color}/year/{year}")
    public ResponseEntity<?> findVehicleByColorYear(@PathVariable String color, @PathVariable int year){
        return ResponseEntity.status(HttpStatus.OK).body(vehicleService.findVehiculoWithColorYear(color, year));
    }

    //Ejercicio #3
    @GetMapping("/vehicles/brand/{brand}/between/{start_year}/{end_year}")
    public ResponseEntity<?> findVehicleByBrandStartYearEndYeard(@PathVariable String brand, @PathVariable int start_year, @PathVariable int end_year){
        return ResponseEntity.status(HttpStatus.OK).body(vehicleService.findVehiculoWithBrandYears(brand,start_year,end_year));
    }

    //Ejercicio #4
    @GetMapping("/vehicles/average_speed/brand/{brand}")
    public ResponseEntity<?> averageSpeedByBrand(@PathVariable String brand){
        return ResponseEntity.status(HttpStatus.OK).body(vehicleService.averageSpeedWithBrand(brand));
    }
}
