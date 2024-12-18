package com.bootcampW22.EjercicioGlobal.controller;

import com.bootcampW22.EjercicioGlobal.dto.*;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.bootcampW22.EjercicioGlobal.service.IVehicleService;
import com.bootcampW22.EjercicioGlobal.service.VehicleServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
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

    @GetMapping("/vehicles/color/{color}/year/{year}")
    public ResponseEntity<List<VehicleDto>> findVehiculeByColorAndYear(@PathVariable String color, @PathVariable int year){
        return new ResponseEntity<List<VehicleDto>>(vehicleService.findCarByColorAndYear(color,year),HttpStatus.OK);
    }
    @GetMapping("/vehicles/average_speed/brand/{brand}")
    public ResponseEntity<ResponseDTO> findAverageMaxSpeedByBrand(@PathVariable String brand){
        return new ResponseEntity<ResponseDTO>(vehicleService.findAverageMaxSpeedByBrand(brand),HttpStatus.OK);
    }
    @GetMapping("/vehicles/brand/{brand}/between/{start_year}/{end_year}")
    public ResponseEntity<List<VehicleDto>> findVehiculeByBrandAndYears(@PathVariable String brand, @PathVariable int start_year, @PathVariable int end_year){
        return new ResponseEntity<List<VehicleDto>>(vehicleService.findCarsByBrandAndYear(brand,start_year,end_year),HttpStatus.OK);
    }
    @PostMapping("/vehicles")
    public ResponseEntity<ResponseDTO> postVehicules(@RequestBody VehicleDto car ){
        return new ResponseEntity<ResponseDTO>(vehicleService.addCar(car),HttpStatus.CREATED);
    }
    @PostMapping("/vehicles/batch")
    public ResponseEntity<ResponseDTO> postVehiculesBatch(@RequestBody List<VehicleDto> car ){
        return new ResponseEntity<ResponseDTO>(vehicleService.addCars(car),HttpStatus.CREATED);
    }
    @PutMapping("/vehicles/{id}/update_speed")
    public ResponseEntity<ResponseDTO> putVehiculesUpdateMaxSpeed(@PathVariable int id, @RequestBody UpdateSpeedRequesDTO max_speed){
        return  new ResponseEntity<ResponseDTO>(vehicleService.updateMaxSpeed(id,max_speed), HttpStatus.OK);

    }
    @DeleteMapping("/vehicles/{id}")
    public ResponseEntity<ResponseDTO> deleteCars(@PathVariable int id){
        return new ResponseEntity<ResponseDTO>(vehicleService.deleteCar(id),HttpStatus.NO_CONTENT);
    }
    //fuel_type update
    //fuel_type liste
    @GetMapping("/vehicles/transmission/{type}")
    public ResponseEntity<List<VehicleDto>> getByTransmissionType(@PathVariable String type ){
        return new ResponseEntity<List<VehicleDto>>(vehicleService.findVehiclesTransmissionByType(type),HttpStatus.OK);
    }
    @PutMapping("vehicles/{id}/update_fuel")
    public ResponseEntity<ResponseDTO> updateTypeFuel(@PathVariable int id, @RequestBody UpdateFuelByIdRequestDTO fuel){
        return new ResponseEntity<ResponseDTO>(vehicleService.putUpdateByTypeFuel(id,fuel),HttpStatus.OK);
    }
    @GetMapping("/vehicles/average_capacity/brand/{brand}")
    public ResponseEntity<?> calAverageByBrand(@PathVariable String brand){
        return new ResponseEntity<AverageCapacityResponseDTO>(vehicleService.averageByPassengers(brand),HttpStatus.OK);
    }
    @GetMapping("/vehicles/dimensions")
    public ResponseEntity<List<VehicleDto>> findByLarge(@RequestParam String length, @RequestParam String width){
        return new ResponseEntity<List<VehicleDto>>(vehicleService.findByLarge(length,width),HttpStatus.OK);
    }
    @GetMapping("/vehicles/weight")
    public ResponseEntity<List<VehicleDto>> findByWeight(@RequestParam double min,@RequestParam double max){
        return new ResponseEntity<List<VehicleDto>>(vehicleService.findCarsByWeight(min,max),HttpStatus.OK);
    }



}
