package com.mercadolibre.cardealership.controller;

import com.mercadolibre.cardealership.dto.VehicleDto;
import com.mercadolibre.cardealership.dto.response.VehicleResDto;
import com.mercadolibre.cardealership.service.IVehicleService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {

    private final IVehicleService vehicleService;

    public VehicleController(IVehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @PostMapping
    public ResponseEntity<String> save(@RequestBody VehicleDto vehicle){
        return ResponseEntity.status(HttpStatus.OK).body(vehicleService.save(vehicle));
    }

    @GetMapping
    public ResponseEntity<List<VehicleResDto>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(vehicleService.findAll());
    }

    @GetMapping("/dates")
    public ResponseEntity<List<VehicleDto>> findByManufacturingDate(
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate since,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate to
    ){
        return ResponseEntity.status(HttpStatus.OK).body(vehicleService.findByManufacturingDate(since, to));
    }

    @GetMapping("/prices")
    public ResponseEntity<List<VehicleDto>> findByPrice(
            @RequestParam Double since,
            @RequestParam Double to){
        return ResponseEntity.status(HttpStatus.OK).body(vehicleService.findByPrice(since, to));
    }

    @GetMapping("/{id}")
    public ResponseEntity<VehicleDto> findById(@PathVariable Integer id){
        return ResponseEntity.status(HttpStatus.OK).body(vehicleService.findById(id));
    }
}
