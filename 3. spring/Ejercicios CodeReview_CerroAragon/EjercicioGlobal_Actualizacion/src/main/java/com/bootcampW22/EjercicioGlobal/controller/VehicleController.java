package com.bootcampW22.EjercicioGlobal.controller;

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

    @PutMapping("/vehicles/{id}/update_fuel")
    public ResponseEntity<String> updateVehicleFuel(@PathVariable Long id, @RequestBody String fuelType) {
        // Validar que el ID sea válido
        if (id <= 0) {
            return new ResponseEntity<> ( HttpStatus.BAD_REQUEST);
        }

        // Validar que el tipo de combustible no sea nulo o vacío
        if (fuelType == null || fuelType.trim().isEmpty()) {
            return new ResponseEntity<>( HttpStatus.BAD_REQUEST);
        }

        vehicleService.updateVehicleFuel(id, fuelType); // Llamar al servicio para actualizar

        return new ResponseEntity<>( HttpStatus.OK);
    }

}
