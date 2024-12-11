package com.bootcamp.practicacodereviewi.controller;


import com.bootcamp.practicacodereviewi.dto.UpdateSpeedDto;
import com.bootcamp.practicacodereviewi.dto.VehicleDto;
import com.bootcamp.practicacodereviewi.service.IVehicleService;
import com.bootcamp.practicacodereviewi.service.VehicleServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("vehicles")
public class VehicleController {

    IVehicleService vehicleService;

    public VehicleController(VehicleServiceImpl vehicleService){
        this.vehicleService = vehicleService;
    }

    @GetMapping
    public ResponseEntity<?> getVehicles(){
        return new ResponseEntity<>(vehicleService.searchAllVehicles(), HttpStatus.OK);
    }

    @GetMapping("color/{color}/year/{year}")
    public ResponseEntity<?> getVehiclesByColorAndYear(@PathVariable String color, @PathVariable int year){
        return new ResponseEntity<>(vehicleService.searchVehiclesByColourAndYear(color, year), HttpStatus.OK);
    }

    @GetMapping("brand/{brand}/between/{start_year}/{end_year}")
    public ResponseEntity<?> getVehiclesByBrandAndBetweenYears(@PathVariable String brand,
                                                               @PathVariable("start_year") int startYear,
                                                               @PathVariable("end_year") int endYear) {
        return new ResponseEntity<>(vehicleService.searchVehiclesByBrandAndRangeOfYears(brand, startYear, endYear), HttpStatus.OK);
    }

    @GetMapping("average_speed/brand/{brand}")
    public ResponseEntity<?> getAverageSpeedFromBrand(@PathVariable String brand){
        return new ResponseEntity<>(vehicleService.getAverageSpeedFromBrand(brand), HttpStatus.OK);
    }

    @GetMapping("dimensions")
    public ResponseEntity<?> getVehiclesByDimentions(@RequestParam double min_width,
                                                     @RequestParam double max_width,
                                                     @RequestParam double min_heigth,
                                                     @RequestParam double max_heigth){
        return new ResponseEntity<>(vehicleService.searchVehiclesByDimensions(min_width, max_width, min_heigth, max_heigth), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createVehicle(@RequestBody VehicleDto request) {
        return new ResponseEntity<>(vehicleService.createVehicle(request), HttpStatus.CREATED);
    }

    @PostMapping("batch")
    public ResponseEntity<?> createListOfVehicles(@RequestBody List<VehicleDto> request) {
        return new ResponseEntity<>(vehicleService.createListOfVehicles(request), HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteVehicle(@PathVariable Long id) {
        vehicleService.deleteVehicle(id);
        return new ResponseEntity<>("", HttpStatus.NO_CONTENT);
    }

    @PatchMapping("{id}/update/update_speed")
    public ResponseEntity<?> updateMaxSpeed(@PathVariable Long id, @RequestBody UpdateSpeedDto request) {
        return new ResponseEntity<>(vehicleService.updateVehicleMaxSpeed(id, request.getMaxSpeed()), HttpStatus.OK);
    }
}
