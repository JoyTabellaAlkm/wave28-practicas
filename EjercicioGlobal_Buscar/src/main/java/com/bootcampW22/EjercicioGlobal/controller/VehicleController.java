package com.bootcampW22.EjercicioGlobal.controller;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.service.IVehicleService;
import com.bootcampW22.EjercicioGlobal.service.VehicleServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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


    @GetMapping("/vehicles/color/{color}/year/{year}")
    public ResponseEntity<List<VehicleDto>> getVehiclesByColorAndYear(
    @PathVariable  String color,
    @PathVariable int year){

    return new ResponseEntity<>(vehicleService.findByColorAndYear (color, year),HttpStatus.OK);

    }

    @GetMapping("vehicles/brand/{brand}/between/{start_year}/{end_year}")
    public ResponseEntity<List<VehicleDto>> getVehiclesByBrandAndYear(
            @PathVariable String brand,
            @PathVariable int start_year,
            @PathVariable int end_year)
    {

         return new ResponseEntity<>(vehicleService.findByBrandAndYear(brand,start_year,end_year),HttpStatus.OK);

    }

 @GetMapping ("vehicles/transmission/{transmission}")
    public ResponseEntity<List<VehicleDto>> getVehiclesByTypeTransmission(
            @PathVariable  String transmission){

         return new ResponseEntity<>(vehicleService.findByTypeTransmission(transmission),HttpStatus.OK);

 }




}
