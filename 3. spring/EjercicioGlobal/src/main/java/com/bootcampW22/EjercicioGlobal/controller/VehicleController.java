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
@RequestMapping("/vehicles")
public class VehicleController {

    IVehicleService vehicleService;

    public VehicleController(VehicleServiceImpl vehicleService) {
        this.vehicleService = vehicleService;
    }

    @GetMapping
    public ResponseEntity<?> findAll() {
        return new ResponseEntity<>(vehicleService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vehicle> findById(@PathVariable Long id){
        return new ResponseEntity<>(vehicleService.findById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}/update_fuel")
    public ResponseEntity<?> updateFuelType(@RequestBody VehicleDto vehicle, @PathVariable Long id){
        return new ResponseEntity<>(vehicleService.updateFuelType(id,vehicle), HttpStatus.OK);
    }

    @PutMapping("/{id}/update_speed")
    public ResponseEntity<?> updateMaxSpeed(@RequestBody VehicleDto vehicle, @PathVariable Long id){
        return new ResponseEntity<>(vehicleService.updateMaxSpeed(id,vehicle), HttpStatus.OK);
    }

    @PostMapping("/batch")
    public ResponseEntity<?> saveMany(@RequestBody List<VehicleDto> vehicles){
        return new ResponseEntity<>(vehicleService.saveMany(vehicles), HttpStatus.CREATED);
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody VehicleDto vehicle){
        return new ResponseEntity<>(vehicleService.save(vehicle), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> remove(@PathVariable Long id){
        return new ResponseEntity<>(vehicleService.remove(id), HttpStatus.NO_CONTENT);
    }

    @GetMapping("/average_capacity/brand/{brand}")
    public ResponseEntity<?> averageCapacityByBrand(@PathVariable String brand){
        return new ResponseEntity<>(vehicleService.averageCapacityByBrand(brand), HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<?> getVehicles() {
        return new ResponseEntity<>(vehicleService.searchAllVehicles(), HttpStatus.OK);
    }

    @GetMapping("/weight")
    public ResponseEntity<?> findByWeightRange(@RequestParam double min, @RequestParam double max){
        return new ResponseEntity<>(vehicleService.findByWeightRange(min, max), HttpStatus.OK);
    }

    @GetMapping("/dimensions")
    public ResponseEntity<?> findByDimensions(@RequestParam String length, @RequestParam String width){
        return new ResponseEntity<>(vehicleService.findByDimensions(length, width), HttpStatus.OK);
    }

    @GetMapping("/color/{color}/year/{year}")
    public ResponseEntity<?> findByColorAndYear(@PathVariable String color, @PathVariable int year) {
        return new ResponseEntity<>(vehicleService.findByColorAndYear(color, year), HttpStatus.OK);
    }

    @GetMapping("/brand/{brand}/between/{start_year}/{end_year}")
    public ResponseEntity<?> findByBrandAndAgeRange(@PathVariable String brand, @PathVariable Integer start_year, @PathVariable Integer end_year) {
        return new ResponseEntity<>(vehicleService.findByBrandAndAgeRange(brand, start_year, end_year), HttpStatus.OK);
    }

    @GetMapping("/average_speed/brand/{brand}")
    public ResponseEntity<?> findByAverageSpeedByBrand(@PathVariable String brand) {
        return new ResponseEntity<>(vehicleService.findByAverageSpeedByBrand(brand), HttpStatus.OK);
    }

    @GetMapping("/fuel_type/{type}")
    public ResponseEntity<?> findByFuelType(@PathVariable String type) {
        return new ResponseEntity<>(vehicleService.findByFuelType(type), HttpStatus.OK);
    }

    @GetMapping("/transmission/{type}")
    public ResponseEntity<?> findByTransmissionType(@PathVariable String type){
        return new ResponseEntity<>(vehicleService.findByTransmissionType(type), HttpStatus.OK);
    }
}
