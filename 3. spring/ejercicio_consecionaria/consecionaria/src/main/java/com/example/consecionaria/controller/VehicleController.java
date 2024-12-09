package com.example.consecionaria.controller;

import com.example.consecionaria.dto.VehicleDTO;
import com.example.consecionaria.dto.request.VehicleByDatesRequest;
import com.example.consecionaria.dto.request.VehicleByPricesRequest;
import com.example.consecionaria.service.IVehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VehicleController {

    @Autowired
    private IVehicleService vehicleService;

    @PostMapping("/vehicles")
    public ResponseEntity<VehicleDTO> crearVehiculo(@RequestBody VehicleDTO request) {
        return ResponseEntity.ok(vehicleService.createVehicle(request));
    }

    @GetMapping("/vehicles")
    public ResponseEntity<List<VehicleDTO>> obtenerVehiculos() {
        return ResponseEntity.ok(vehicleService.getVehicles());
    }

    ///vehicles/dates?since=2004-11-21&to=2004-11-22 url de ejemplo
    @GetMapping("/vehicles/dates")
    public ResponseEntity<List<VehicleDTO>> getVehiclesByDates(VehicleByDatesRequest request) {
        return ResponseEntity.ok(vehicleService.getVehiclesByDate(request));
    }

    @GetMapping("/vehicles/prices")
    public ResponseEntity<List<VehicleDTO>> getVehiclesByPrices(VehicleByPricesRequest request) {
        return ResponseEntity.ok(vehicleService.getVehiclesByPrices(request));
    }

    @GetMapping("/vehicles/{id}")
    public ResponseEntity<VehicleDTO> obtenerVehiculoPorId(@PathVariable("id") int id) {
        VehicleDTO response = vehicleService.getById(id);
        if (response != null)
            return ResponseEntity.ok(response);
        return ResponseEntity.notFound().build();
    }

}
