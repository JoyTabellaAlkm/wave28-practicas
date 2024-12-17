package com.bootcampW22.EjercicioGlobal.controller;

import com.bootcampW22.EjercicioGlobal.dto.Request.RequestCreateVehicleDTO;
import com.bootcampW22.EjercicioGlobal.dto.Request.RequestUpdateFuelDTO;
import com.bootcampW22.EjercicioGlobal.dto.Request.RequestUpdateSpeedDTO;
import com.bootcampW22.EjercicioGlobal.service.IVehicleService;
import com.bootcampW22.EjercicioGlobal.service.VehicleServiceImpl;
import jakarta.validation.Valid;
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

    // Crear vehiculo
    @PostMapping("/vehicles")
    public ResponseEntity<?> addNewVehicle(@Valid @RequestBody RequestCreateVehicleDTO vehicle){
        return new ResponseEntity<>(vehicleService.addNewVehicle(vehicle), HttpStatus.CREATED);
    }

    // Buscar vehiculo por color y año
    @GetMapping("/vehicles/color/{color}/year/{year}")
    public ResponseEntity<?> findByColorAndYear(@PathVariable String color, @PathVariable int year){
        return new ResponseEntity<>(vehicleService.findByColorAndYear(color, year), HttpStatus.OK);
    }

    // Buscar vehículos por marca y rango de años
    @GetMapping("/vehicles/brand/{brand}/between/{start_year}/{end_year}")
    public ResponseEntity<?> findByBrandAndYears(@PathVariable String brand, @PathVariable int start_year, @PathVariable int end_year){
        return new ResponseEntity<>(vehicleService.findByBrandAndYears(brand, start_year, end_year), HttpStatus.OK);
    }

    @GetMapping("/vehicles/average_speed/brand/{brand}")
    public ResponseEntity<?> averageSpeedByBrand(@PathVariable String brand){
        return new ResponseEntity<>(vehicleService.averageSpeedByBrand(brand), HttpStatus.OK);
    }

    @PostMapping("/vehicles/batch")
    public ResponseEntity<?> createMultipleVehicules(@RequestBody List<RequestCreateVehicleDTO> vehicles){
        return new ResponseEntity<>(vehicleService.createMultipleVehicles(vehicles), HttpStatus.CREATED);
    }

    // Actualizar combustible vehiculo
    @PutMapping("/vehicles/{id}/update_speed")
    public ResponseEntity<?> updateMaxSpeed(@PathVariable Long id,@RequestBody RequestUpdateSpeedDTO speed){
        return new ResponseEntity<>(vehicleService.updateMaxSpeed(id, speed), HttpStatus.OK);
    }

    // Listar por tipo de combustible
    @GetMapping("/vehicles/fuel_type/{type}")
    public ResponseEntity<?> getVehiclesByFuelType(@PathVariable String type){
        return new ResponseEntity<>(vehicleService.getVehiclesByFuelType(type), HttpStatus.OK);
    }

    // Eliminar un vehiculo
    @DeleteMapping("/vehicles/{id}")
    public ResponseEntity<?> deleteVehicle(@PathVariable Long id){
        return new ResponseEntity<>(vehicleService.deleteVehicle(id), HttpStatus.NO_CONTENT);
    }

    // Buscar vehiculo por tipo de transmisión
    @GetMapping("/vehicles/transmission/{type}")
    public ResponseEntity<?> getVehiclesByTransmission(@PathVariable String type){
        return new ResponseEntity<>(vehicleService.getVehiclesByTransmission(type), HttpStatus.OK);
    }

    // Actualizar tipo de combustible
    @PutMapping("/vehicles/{id}/update_fuel")
    public ResponseEntity<?> updateFuel(@PathVariable Long id, @RequestBody RequestUpdateFuelDTO fuel){
        return new ResponseEntity<>(vehicleService.updateFuel(id, fuel), HttpStatus.OK);
    }

    // Obtener capacidad promedio de personas por marca
    @GetMapping("/vehicles/average_capacity/brand/{brand}")
    public ResponseEntity<?> getAveragePassengersByBrand(@PathVariable String brand){
        return new ResponseEntity<>(vehicleService.getAveragePassengersByBrand(brand), HttpStatus.OK);
    }

}
