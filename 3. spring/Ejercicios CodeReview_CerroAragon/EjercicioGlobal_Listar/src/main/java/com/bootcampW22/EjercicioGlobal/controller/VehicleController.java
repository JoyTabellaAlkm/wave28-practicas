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

    @GetMapping("/fuel_type/{type}")
    public ResponseEntity<List<VehicleDto>> getVehiclesByFuelType(
            @PathVariable String type) {
        List<VehicleDto> vehiculosDto = vehicleService.findByFuelType(type); // Llama al servicio con el tipo de combustible


        return new ResponseEntity<>(vehiculosDto, HttpStatus.OK); // 200 OK con la lista de vehículos
    }

    @GetMapping("/vehicles/weight")
    public ResponseEntity<List<VehicleDto>> getVehiclesByWight(
            @RequestParam double min,
            @RequestParam double max) {
        List<VehicleDto> vehiculosDto = vehicleService.findByWeightRange(min, max);

        return new ResponseEntity<>(vehiculosDto, HttpStatus.OK);
    }

    @GetMapping("/vehicles/average_capacity/brand/{brand}")
    public ResponseEntity<AvarageCapacityDto> getAverageCapacityByBrand
            (@PathVariable String brand) {
        AvarageCapacityDto averageCapacityDto = vehicleService.calculateAverageCapacityByBrand(brand);

        return new ResponseEntity<>(averageCapacityDto, HttpStatus.OK);
    }

    @GetMapping ("/vehicles/average_speed/brand/{brand}")
    public ResponseEntity<AvarageSpeedDto> getAvarageSpedByBrand
            (@PathVariable String brand) {
        AvarageSpeedDto avarageSpeedDto = vehicleService.calculateAverageSpeedByBrand(brand);


        return new ResponseEntity<>(avarageSpeedDto, HttpStatus.OK);
    }


}