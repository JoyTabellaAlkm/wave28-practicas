package com.bootcampW22.EjercicioGlobal.controller;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.service.IVehicleService;
import com.bootcampW22.EjercicioGlobal.service.VehicleServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {

    IVehicleService vehicleService;

    public VehicleController(VehicleServiceImpl vehicleService){
        this.vehicleService = vehicleService;
    }

    @GetMapping("")
    public ResponseEntity<?> getVehicles(){
        return new ResponseEntity<>(vehicleService.searchAllVehicles(), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<VehicleDto> postVehicles(@RequestBody VehicleDto vehicle){
        return new ResponseEntity<VehicleDto>(vehicleService.postAVehicle(vehicle), HttpStatus.CREATED);
    }

    @GetMapping("/dimensions/")
    public ResponseEntity<?> getVehiclesDimensions(@RequestParam String length,
                                                   @RequestParam String width){
        return new ResponseEntity<>(vehicleService.searchVehiclesByDimensions(length,width), HttpStatus.OK);
    }

    @GetMapping("/average_capacity/brand/{brand}")
    public ResponseEntity<?> getVehiclesDimensions(@PathVariable String brand){
        return new ResponseEntity<Double>(vehicleService.averageCapacity(brand), HttpStatus.OK);
    }

}
