package com.bootcampW22.EjercicioGlobal.controller;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.service.IVehicleService;
import com.bootcampW22.EjercicioGlobal.service.VehicleServiceImpl;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {

    private final IVehicleService vehicleService;

    public VehicleController(VehicleServiceImpl vehicleService) {
        this.vehicleService = vehicleService;
    }

    @PostMapping
    public ResponseEntity<String> save(@RequestBody @Valid VehicleDto vehicle) {
        return new ResponseEntity<>(vehicleService.save(vehicle), HttpStatus.CREATED);
    }

    @PostMapping("/batch")
    public ResponseEntity<String> multipleSaving(@RequestBody @Validated List<VehicleDto> vehicles) {
        return new ResponseEntity<>(vehicleService.multipleSaving(vehicles), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> findAll() {
        return new ResponseEntity<>(vehicleService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/color/{color}/year/{year}")
    public ResponseEntity<?> findByColorAndYear(@PathVariable String color, @PathVariable int year) {
        return new ResponseEntity<>(vehicleService.findByColorAndYear(color, year), HttpStatus.OK);
    }

    @GetMapping("/brand/{brand}/between/{startYear}/{endYear}")
    public ResponseEntity<?> findByBrandAndBetweenYear(@PathVariable String brand, @PathVariable int startYear, @PathVariable int endYear) {
        return new ResponseEntity<>(vehicleService.findByBrandAndBetweenYear(brand, startYear, endYear), HttpStatus.OK);
    }

    @GetMapping("/average_speed/brand/{brand}")
    public ResponseEntity<?> averageSpeedByBrand(@PathVariable String brand) {
        return new ResponseEntity<>(vehicleService.averageSpeedByBrand(brand), HttpStatus.OK);
    }

    @GetMapping("/fuel_type/{type}")
    public ResponseEntity<?> findByFuelType(@PathVariable String type) {
        return new ResponseEntity<>(vehicleService.findByFuelType(type), HttpStatus.OK);
    }

    @GetMapping("/transmission/{type}")
    public ResponseEntity<?> findByTransmissionType(@PathVariable String type) {
        return new ResponseEntity<>(vehicleService.findByTransmissionType(type), HttpStatus.OK);
    }

    @GetMapping("/average_capacity/brand/{brand}")
    public ResponseEntity<?> averageCapacityByBrand(@PathVariable String brand) {
        return new ResponseEntity<>(vehicleService.averageCapacityByBrand(brand), HttpStatus.OK);
    }

    @GetMapping("/dimensions")
    public ResponseEntity<?> findByDimensions(@RequestParam String length, @RequestParam String width) {
        return new ResponseEntity<>(vehicleService.findByDimensions(length, width), HttpStatus.OK);
    }

    @GetMapping("/weight")
    public ResponseEntity<?> findByWeightRange(@RequestParam double min, @RequestParam double max) {
        return new ResponseEntity<>(vehicleService.findByWeightRange(min, max), HttpStatus.OK);
    }

    @PutMapping("/{id}/update_speed")
    public ResponseEntity<?> updateMaxSpeed(@PathVariable Long id, @Valid @RequestBody VehicleDto vehicle) {
        return new ResponseEntity<>(vehicleService.updateMaxSpeed(id, vehicle), HttpStatus.OK);
    }

    @PutMapping("/{id}/update_fuel")
    public ResponseEntity<?> updateFuelType(@PathVariable Long id, @Valid @RequestBody VehicleDto vehicle) {
        return new ResponseEntity<>(vehicleService.updateFuelType(id, vehicle), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> remove(@PathVariable Long id) {
        return new ResponseEntity<>(vehicleService.remove(id), HttpStatus.NO_CONTENT);
    }
}
