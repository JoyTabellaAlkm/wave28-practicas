package com.bootcampW22.EjercicioGlobal.controller;

import com.bootcampW22.EjercicioGlobal.dto.UpdateVehicleBySpeedDTO;
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

    public VehicleController(VehicleServiceImpl vehicleService){
        this.vehicleService = vehicleService;
    }

    @GetMapping("/vehicles")
    public ResponseEntity<?> getVehicles(){
        return new ResponseEntity<>(vehicleService.searchAllVehicles(), HttpStatus.OK);
    }

    @GetMapping("/vehicles/average_speed/brand/{brand}")
    public ResponseEntity<?> getSpeedByBrand(@PathVariable String brand){
        return ResponseEntity.status(HttpStatus.OK)
                .body(vehicleService.getAllVehiclesByBrand(brand));
    }

    @GetMapping("/vehicles/fuel_type/{type}")
    public ResponseEntity<?> getVehiclesByFuelType(@PathVariable String type){
        return ResponseEntity.status(HttpStatus.OK)
                .body(vehicleService.getAllVehiclesByFullSpeed(type));
    }

    @DeleteMapping("/vehicles/{id}")
    public ResponseEntity<?>  deleteVehicle(@PathVariable int id) {
        return ResponseEntity.status(HttpStatus.NO_CONTENT)
                .body(vehicleService.deleteVehicleById(id));
    }

    @PostMapping("/vehicles")
    public ResponseEntity<?> createVehicle(@RequestBody VehicleDto vehicleDto){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(vehicleService.createVehicle(vehicleDto));
    }

    @PutMapping("/vehicles/{id}/update_speed")
    public ResponseEntity<?> updateVehicleBySpeed(@PathVariable long id, @RequestBody UpdateVehicleBySpeedDTO updateVehicleBySpeedDTO){

        return  ResponseEntity.status(HttpStatus.OK)
                .body(vehicleService.updateVehicleBySpeed(id, updateVehicleBySpeedDTO));
    }

    @PostMapping("/vehicles/batch")
    public ResponseEntity<?> createMultipleVehicle(@RequestBody List<VehicleDto> vehiclesDtos){

        return  ResponseEntity.status(HttpStatus.CREATED)
                .body(vehicleService.createMultipleVehicles(vehiclesDtos));

    }



}
