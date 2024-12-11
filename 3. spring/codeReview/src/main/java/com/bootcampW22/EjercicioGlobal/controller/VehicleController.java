package com.bootcampW22.EjercicioGlobal.controller;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.bootcampW22.EjercicioGlobal.service.IVehicleService;
import com.bootcampW22.EjercicioGlobal.service.VehicleServiceImpl;
import jakarta.websocket.server.PathParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class VehicleController {

    IVehicleService vehicleService;

    public VehicleController(VehicleServiceImpl vehicleService){
        this.vehicleService = vehicleService;
    }

    @GetMapping("/vehicles/color/{color}/year/{year}")
    public ResponseEntity<?> findByColorAndYear(@PathVariable String color, @PathVariable String year){
        return new ResponseEntity<>(vehicleService.searchByColorAndYear(color,year), HttpStatus.OK);
    }

    @GetMapping("/vehicles")
    public ResponseEntity<?> getVehicles(){
        return new ResponseEntity<>(vehicleService.searchAllVehicles(), HttpStatus.OK);
    }

    @PostMapping("/vehicles")
    public ResponseEntity<?>addVehicle(@RequestBody VehicleDto vehicle){
        return new ResponseEntity<>(vehicleService.addVehicle(vehicle), HttpStatus.OK);
    }

    @PutMapping("/vehicles/{id}/update_speed")
    public ResponseEntity<?>updateSpeed(@PathVariable String id, @RequestBody String newSpeed){
        return new ResponseEntity<>(vehicleService.updateSpeed(id, newSpeed), HttpStatus.OK);
    }

    @GetMapping("/vehicles/weight")
    public ResponseEntity<?>listByWeightRange(@RequestParam Double min, @RequestParam Double max){
        return new ResponseEntity<>(vehicleService.listByWeightRange(min,max), HttpStatus.OK);
    }
}
