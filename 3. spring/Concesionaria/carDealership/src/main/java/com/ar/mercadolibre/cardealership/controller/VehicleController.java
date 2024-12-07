package com.ar.mercadolibre.cardealership.controller;

import com.ar.mercadolibre.cardealership.dto.response.VehicleBasicDTO;
import com.ar.mercadolibre.cardealership.dto.response.VehicleDTO;
import com.ar.mercadolibre.cardealership.dto.request.VehicleCreationDTO;
import com.ar.mercadolibre.cardealership.service.IVehicleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api/vehicles")
public class VehicleController {

    private final IVehicleService vehicleService;

    public VehicleController(IVehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @PostMapping("")
    public ResponseEntity<?> create(@RequestBody VehicleCreationDTO vehicle) {
        VehicleDTO vehicleDTO = vehicleService.create(vehicle);

        if(vehicleDTO == null) {
            return new ResponseEntity<>("The vehicle could not be registered", HttpStatus.OK);
        }

        return new ResponseEntity<>(vehicleDTO, HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<?> getAllVehicles() {
        List<VehicleBasicDTO> vehicleBasicDTOs = vehicleService.getAll();

        if(vehicleBasicDTOs.isEmpty()) {
            return new ResponseEntity<>("No vehicles registered", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(vehicleBasicDTOs, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        VehicleDTO vehicleDTO = vehicleService.getById(id);
        if(vehicleDTO == null) {
            return new ResponseEntity<>("No vehicle found", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(vehicleDTO, HttpStatus.OK);
    }

    @GetMapping("/prices")
    public ResponseEntity<?> getByPriceRange(@RequestParam String from, @RequestParam String to) {
        List<VehicleDTO> vehicleDTOs = vehicleService.getByPriceRange(from, to);
        if(vehicleDTOs.isEmpty()) {
            return new ResponseEntity<>("No vehicles found with prices between " + from + " and " + to, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(vehicleDTOs, HttpStatus.OK);
    }

    @GetMapping("/dates")
    public ResponseEntity<?> getByDateRange(@RequestParam String from, @RequestParam String to) {
        List<VehicleDTO> vehicleDTOs = vehicleService.getByDateRange(from, to);
        if(vehicleDTOs.isEmpty()) {
            return new ResponseEntity<>("No vehicles found with manufacturing date between " + from + " and " + to, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(vehicleDTOs, HttpStatus.OK);
    }
}
