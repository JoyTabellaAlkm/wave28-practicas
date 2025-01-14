package com.mercadolibre.Insurance.controller;

import com.mercadolibre.Insurance.dto.request.VehiculoRequestDTO;
import com.mercadolibre.Insurance.dto.response.VehiculoResponseDTO;
import com.mercadolibre.Insurance.service.IVehiculosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VehiculoController {
    @Autowired
    IVehiculosService vehiculosService;

    @PostMapping("/create")
    public ResponseEntity<VehiculoResponseDTO> crearVehiculo(@RequestBody VehiculoRequestDTO vehiculo){
        return ResponseEntity.ok(vehiculosService.createVehiculo(vehiculo));
    }

    @GetMapping()
    public ResponseEntity<List<VehiculoResponseDTO>> traerTodos(){
        return ResponseEntity.ok(vehiculosService.findAll());
    }
}
