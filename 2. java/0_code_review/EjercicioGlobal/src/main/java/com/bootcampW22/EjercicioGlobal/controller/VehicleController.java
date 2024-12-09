package com.bootcampW22.EjercicioGlobal.controller;

import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.bootcampW22.EjercicioGlobal.service.IVehicleService;
import com.bootcampW22.EjercicioGlobal.service.VehicleServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@Validated
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
    public ResponseEntity<?> save(@RequestBody Vehicle vehicle) throws IOException {
        return new ResponseEntity<>(vehicleService.saveVehicle(vehicle), HttpStatus.CREATED);
    }

    @GetMapping("/vehicles/color/{color}/year/{year}")
    public ResponseEntity<?> findByColorAndYear(@PathVariable String color,  @PathVariable Integer year){
        return new ResponseEntity<>(vehicleService.findVehiclesByColorAndYear(color, year), HttpStatus.OK);
    }

    @GetMapping("/vehicles/brand/{brand}/between/{start_year}/{end_year}")
    public ResponseEntity<?> findByBrandAndYears(@PathVariable String brand,  @PathVariable Integer start_year,
                                                 @PathVariable Integer end_year){
        return new ResponseEntity<>(vehicleService.findVehiclesByBrandAndYears(brand, start_year, end_year), HttpStatus.OK);
    }

    @GetMapping("/vehicles/average_speed/brand/{brand}")
    public ResponseEntity<?> averageSpeedByBrand(@PathVariable String brand){
        return new ResponseEntity<>(vehicleService.averageSpeedByBrand(brand), HttpStatus.OK);
    }

    @PostMapping("/vehicles/batch")
    public ResponseEntity<?> saveVehiclesBatch(@RequestBody List<Vehicle> vehicles){
        return new ResponseEntity<>(vehicleService.saveVehiclesBatch(vehicles), HttpStatus.CREATED);
    }

    @PutMapping("/vehicles/{id}/update_speed")
    public ResponseEntity<?> updateVehicle(@PathVariable Long id, @RequestBody Vehicle vehicle){
        return new ResponseEntity<>(vehicleService.updateSpeed(id, vehicle.getMax_speed()), HttpStatus.OK);
    }

    @GetMapping("/vehicles/fuel_type/{type}")
    public  ResponseEntity<?> findByFuelType(@PathVariable String type){
        return  new ResponseEntity<>(vehicleService.findVehicleByFuel(type), HttpStatus.OK);
    }

    @DeleteMapping("/vehicles/{id}")
    public ResponseEntity<?> deleteVehicle(@PathVariable Long id){
        return new ResponseEntity<>(vehicleService.deleteVehicle(id), HttpStatus.OK);
    }
}

