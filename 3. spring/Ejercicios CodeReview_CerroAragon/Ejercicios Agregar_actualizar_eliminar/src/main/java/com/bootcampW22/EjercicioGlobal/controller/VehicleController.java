package com.bootcampW22.EjercicioGlobal.controller;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.service.IVehicleService;
import com.bootcampW22.EjercicioGlobal.service.VehicleServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
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

    @PostMapping("/vehicle")
    public ResponseEntity<?>addVehicle(@RequestBody VehicleDto vehicleDto){
        return new ResponseEntity<>(vehicleService.addVehicle(vehicleDto), HttpStatus.CREATED);

    }

    @PostMapping("/vehicles")
    public ResponseEntity<?>addVehicles(@RequestBody List<VehicleDto> vehicleDtoList){
        return new ResponseEntity<>(vehicleService.addVehicles(vehicleDtoList),HttpStatus.CREATED);

    }


    @DeleteMapping("/vehicles/{id}")
    public ResponseEntity<?> deleteVehicle(@PathVariable Long id){
        return new ResponseEntity<>(vehicleService.deleteVehicle(id),HttpStatus.NO_CONTENT);

    }

    @PutMapping("/vehicles/{id}/update_speed")
    public ResponseEntity<?> updateSpeedId(@PathVariable Long id, @RequestBody String max_speed){
        return new ResponseEntity<>(vehicleService.updateMax_speed(id,max_speed),HttpStatus.OK);
    }

    @PutMapping("vehicles/{id}/update_fuel")
    public ResponseEntity<?> UpdateFuelById(@PathVariable Long id, @RequestBody String fuel_type){
        return new ResponseEntity<>(vehicleService.updateByIdFuel(id,fuel_type),HttpStatus.OK);

   }



}
