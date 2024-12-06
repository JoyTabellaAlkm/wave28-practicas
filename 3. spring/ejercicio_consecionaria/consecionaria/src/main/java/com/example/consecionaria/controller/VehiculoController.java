package com.example.consecionaria.controller;

import com.example.consecionaria.dto.VehiculoDTO;
import com.example.consecionaria.dto.request.GetVehiclesByDateRequest;
import com.example.consecionaria.dto.request.GetVehiclesByPricesRequest;
import com.example.consecionaria.entity.Vehiculo;
import com.example.consecionaria.service.IVehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class VehiculoController {

    @Autowired
    private IVehiculoService vehiculoService;

    @PostMapping("/vehicles")
    public ResponseEntity<VehiculoDTO> crearVehiculo(@RequestBody VehiculoDTO request) {
        return ResponseEntity.ok(vehiculoService.crearVehiculo(request));
    }

    @GetMapping("/vehicles")
    public ResponseEntity<VehiculoDTO> obtenerVehiculos() {
        return ResponseEntity.ok(null);
    }

    @GetMapping("/vehicles/dates")
    public ResponseEntity<VehiculoDTO> obtenerVehiculosPorFechas(GetVehiclesByDateRequest request) {
        return ResponseEntity.ok(null);
    }

    @GetMapping("/vehicles/prices")
    public ResponseEntity<VehiculoDTO> obtenerVehiculosPorPrecios(GetVehiclesByPricesRequest request) {
        return ResponseEntity.ok(null);
    }

    @GetMapping("/vehicles/{id}")
    public ResponseEntity<VehiculoDTO> obtenerVehiculoPorId(@PathVariable("id") int id) {
        return ResponseEntity.ok(null);
    }

}
