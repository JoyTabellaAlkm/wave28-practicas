package com.bootcampW22.EjercicioGlobal.controller;
import com.bootcampW22.EjercicioGlobal.dto.AvarageCapacityDto;
import com.bootcampW22.EjercicioGlobal.dto.AvarageSpeedDto;
import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.service.IVehicleService;
import com.bootcampW22.EjercicioGlobal.service.VehicleServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VehicleController {

    IVehicleService vehicleService;

    public VehicleController(VehicleServiceImpl vehicleService) {
        this.vehicleService = vehicleService;
    }

    @GetMapping("/vehicles")
    public ResponseEntity<?> getVehicles() {
        return new ResponseEntity<>(vehicleService.searchAllVehicles(), HttpStatus.OK);
    }

    @GetMapping("/fuel_type/{fuel_type}")
    public ResponseEntity<?> getVehiclesByFuelType(
            @PathVariable String fuel_type) {

        return new ResponseEntity<>(vehicleService.findByFuelType(fuel_type), HttpStatus.OK);
    }

    @GetMapping("/vehicles/weight?min={weight_min}&max={weight_max}")
    public ResponseEntity<?> getVehiclesByWight(
            @RequestParam double min,
            @RequestParam double max) {

        return new ResponseEntity<>(vehicleService.findByWeightRange(min, max), HttpStatus.OK);
    }

    @GetMapping("/vehicles/average_capacity/brand/{brand}")
    public ResponseEntity<AvarageCapacityDto> getAverageCapacityByBrand
            (@PathVariable String brand) {

        return new ResponseEntity<>(vehicleService.calculateAverageCapacityByBrand(brand), HttpStatus.OK);
    }

    @GetMapping ("/vehicles/average_speed/brand/{brand}")
    public ResponseEntity<AvarageSpeedDto> getAvarageSpedByBrand
            (@PathVariable String brand) {

        return new ResponseEntity<>(vehicleService.calculateAverageSpeedByBrand(brand), HttpStatus.OK);
    }


}