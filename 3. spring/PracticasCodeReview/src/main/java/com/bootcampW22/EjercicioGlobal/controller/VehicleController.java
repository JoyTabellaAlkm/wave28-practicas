package com.bootcampW22.EjercicioGlobal.controller;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.bootcampW22.EjercicioGlobal.service.IVehicleService;
import com.bootcampW22.EjercicioGlobal.service.VehicleServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VehicleController {

    IVehicleService vehicleService;

    public VehicleController(VehicleServiceImpl vehicleService){
        this.vehicleService = vehicleService;
    }

    @GetMapping("/vehicles")
    public ResponseEntity<?> getVehicles(){
        return new ResponseEntity<>(vehicleService.searchAllVehicles(), HttpStatus.OK);
    }

    @PostMapping("/vehicles")
    public ResponseEntity<?> addVehicle(@RequestBody VehicleDto vehicleDto){
        vehicleService.addNewVehicle(vehicleDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/color/{color}/year/{year}")
    public ResponseEntity<?> listByColorAndYear(@PathVariable String color, @PathVariable Integer year){
        return new ResponseEntity<>(vehicleService.getByColorAndYear(color, year), HttpStatus.OK);
    }

    @GetMapping("/vehicles/brand/{brand}/between/{start_year}/{end_year}")
    public ResponseEntity<?> findBetweenYears(@PathVariable String brand, @PathVariable Integer start_year, @PathVariable Integer end_year){
        System.out.println(start_year + end_year);
        return ResponseEntity.ok(vehicleService.findBetweenYears(brand, start_year, end_year));
    }

    @GetMapping("/vehicles/average_speed/brand/{brand}")
    public ResponseEntity<?> findAverageSpeedByBrand(@PathVariable String brand){
        return ResponseEntity.ok(vehicleService.findAverageSpeedByBrand(brand));
    }

    @PostMapping("/vehicles/batch")
    public ResponseEntity<?> postMultipleVehicles(@RequestBody List<VehicleDto> vehicles){
        return ResponseEntity.ok(vehicleService.postMultipleVehicles(vehicles));
    }

    @PutMapping("/vehicles/{id}/update_speed")
    public ResponseEntity<?> updateSpeed(@PathVariable Long id, @RequestParam Double speed){
        return ResponseEntity.ok(vehicleService.updateSpeed(speed, id));
    }
}
