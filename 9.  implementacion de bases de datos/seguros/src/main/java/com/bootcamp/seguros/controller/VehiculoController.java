
package com.bootcamp.seguros.controller;

import com.bootcamp.seguros.dto.request.VehiculoRequestDTO;
import com.bootcamp.seguros.dto.response.VehiculoPatenteYMarcaDTO;
import com.bootcamp.seguros.dto.response.VehiculoResponseDTO;
import com.bootcamp.seguros.service.IVehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VehiculoController {
    @Autowired
    IVehiculoService vehiculoService;

    @PostMapping("/create")
    public ResponseEntity<VehiculoResponseDTO> crearVehiculo(@RequestBody VehiculoRequestDTO vehiculo){
        return ResponseEntity.ok(vehiculoService.createVehiculo(vehiculo));
    }

    @GetMapping()
    public ResponseEntity<List<VehiculoResponseDTO>> traerTodos(){
        return ResponseEntity.ok(vehiculoService.findAll());
    }

    @GetMapping("/patentes")
    public ResponseEntity<List<String>> traerPatentes() {
        return ResponseEntity.ok(vehiculoService.findAllPatentes());
    }

    @GetMapping("/patente-marca")
    public ResponseEntity<List<VehiculoPatenteYMarcaDTO>> traerPatenteMarca() {
        return ResponseEntity.ok(vehiculoService.findAllPatentesAndMarca());
    }

    @GetMapping("/patente-marca-anio")
    public ResponseEntity<List<String>> traerPatenteConMasDe$RuedasYAnioActual(@RequestParam Integer anioActual) {
        return ResponseEntity.ok(vehiculoService.findPatentesRuedasAndAnio(anioActual));
    }
}
