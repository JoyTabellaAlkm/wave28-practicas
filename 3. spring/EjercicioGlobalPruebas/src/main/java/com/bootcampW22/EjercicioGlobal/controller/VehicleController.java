package com.bootcampW22.EjercicioGlobal.controller;

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

    @GetMapping()
    public ResponseEntity<?> getVehicles(){
        return new ResponseEntity<>(vehicleService.searchAllVehicles(), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<?> postVehicles(){
        return new ResponseEntity<>(vehicleService.searchAllVehicles(),HttpStatus.OK);
    }
    @GetMapping("/average_speed/brand/{brand}")
    public ResponseEntity<?> averageSpeedByBrand(@PathVariable String brand){
        return new ResponseEntity<>(vehicleService.averageSpeedByBrand(brand),HttpStatus.OK);
    }
}
