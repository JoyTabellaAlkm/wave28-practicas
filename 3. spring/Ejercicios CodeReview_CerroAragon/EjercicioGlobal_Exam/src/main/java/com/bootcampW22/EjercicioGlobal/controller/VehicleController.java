package com.bootcampW22.EjercicioGlobal.controller;

import com.bootcampW22.EjercicioGlobal.dto.AverageVehicleDto;
import com.bootcampW22.EjercicioGlobal.service.IVehicleService;
import com.bootcampW22.EjercicioGlobal.service.VehicleServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/vehicles/average_capacity/brand/{brand}")
    public ResponseEntity<AverageVehicleDto> getAverageByBrand(@PathVariable String brand) {

        AverageVehicleDto averageVehiculosDto = vehicleService.FindByBrandByPassager(brand);
       // if (averageVehiculos.getAverageByBrand() == 0) {
         //   return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        //}
        return new ResponseEntity<>(averageVehiculosDto, HttpStatus.OK);
    }
}

