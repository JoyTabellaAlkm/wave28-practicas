package com.bootcampW22.EjercicioGlobal.controller;

import com.bootcampW22.EjercicioGlobal.service.IVehicleService;
import com.bootcampW22.EjercicioGlobal.service.VehicleServiceImpl;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
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
    //Buscar vehículos por color y año
    @GetMapping("/color/{color}/year/{year}")
    public ResponseEntity<?> getVehiclesByColorAndYear(@PathVariable String color, @PathVariable int year){
        return new ResponseEntity<>(vehicleService.searchVehiclesByYearAndColor(color,year),HttpStatus.OK);
    }
    //Buscar vehículos por marca y rango de años
    @GetMapping("/brand/{brand}/between/{start_year}/{end_year}")
    public ResponseEntity<?> getVehiclesByColorAndRangeOfYear(@PathVariable String brand, @PathVariable int start_year, @PathVariable int end_year){
        return new ResponseEntity<>(vehicleService.searchVehiclesByBrandAndRangeOfYear(brand,start_year,end_year),HttpStatus.OK);
    }
    //Consultar velocidad promedio por marca
    @GetMapping("/average_speed/brand/{brand}")
    public ResponseEntity<?> getAverageSpeedByBrand(@PathVariable String brand){
        return new ResponseEntity<>(vehicleService.calculateAvgSpeedByBrand(brand),HttpStatus.OK);
    }
    //Obtener la capacidad promedio de personas por marca
    @GetMapping("/average_capacity/brand/{brand}")
    public ResponseEntity<?> getAverageCapacityByBrand(@PathVariable String brand){
        return new ResponseEntity<>(vehicleService.calculateAvgCapacityByBrand(brand),HttpStatus.OK);
    }
    //Listar vehículos por rango de peso
    @GetMapping("/weight")
    public ResponseEntity<?> getVehiclesByRangeOfWeight(@RequestParam double min, @RequestParam double max){
        return new ResponseEntity<>(vehicleService.searchVehiclesByRangeOfWeight(min,max),HttpStatus.OK);
    }
}
