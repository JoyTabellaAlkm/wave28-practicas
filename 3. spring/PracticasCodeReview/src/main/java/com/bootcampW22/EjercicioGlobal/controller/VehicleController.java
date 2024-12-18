package com.bootcampW22.EjercicioGlobal.controller;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.service.IVehicleService;
import com.bootcampW22.EjercicioGlobal.service.VehicleServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<?> listByColorAndYear(@PathVariable String color, Integer year){
        return ResponseEntity.ok(vehicleService.getByColorAndYear(color, year));
    }
}
