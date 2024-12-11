package com.bootcampW22.EjercicioGlobal.controller;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.bootcampW22.EjercicioGlobal.service.IVehicleService;
import com.bootcampW22.EjercicioGlobal.service.VehicleServiceImpl;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {

    IVehicleService vehicleService;

    public VehicleController(VehicleServiceImpl vehicleService){
        this.vehicleService = vehicleService;
    }

    @GetMapping
    public ResponseEntity<?> getVehicles(){
        return new ResponseEntity<>(vehicleService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> save(@RequestBody @Valid VehicleDto vehicle){
        return new ResponseEntity<>(vehicleService.save(vehicle), HttpStatus.CREATED);
    }

    @PostMapping("/batch")
    public ResponseEntity<String> multipleSaving(@RequestBody @Valid List<VehicleDto> vehicles){
        return new ResponseEntity<>(vehicleService.multipleSaving(vehicles), HttpStatus.CREATED);
    }

    @PutMapping("/{id}/update_speed")
    public ResponseEntity<String> updateMaxSpeed(@PathVariable Long id, @Valid @RequestBody VehicleDto vehicle){
        return new ResponseEntity<>(vehicleService.updateMaxSpeed(id, vehicle), HttpStatus.OK);
    }

    @PutMapping("/{id}/update_fuel")
    public ResponseEntity<String> updateFuelType(@PathVariable Long id, @Valid @RequestBody VehicleDto vehicle){
        return new ResponseEntity<>(vehicleService.updateFuelType(id, vehicle), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> updateFuelType(@PathVariable Long id){
        return new ResponseEntity<>(vehicleService.remove(id), HttpStatus.NO_CONTENT);
    }
}
