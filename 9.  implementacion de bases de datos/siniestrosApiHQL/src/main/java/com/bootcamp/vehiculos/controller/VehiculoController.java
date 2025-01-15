package com.bootcamp.vehiculos.controller;

import com.bootcamp.vehiculos.dto.PatenteMarcaDto;
import com.bootcamp.vehiculos.dto.PatenteMarcaModeloDto;
import com.bootcamp.vehiculos.dto.PerdidaVehiculoDto;
import com.bootcamp.vehiculos.entity.Vehiculo;
import com.bootcamp.vehiculos.service.VehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehiculos")
public class VehiculoController {

    @Autowired
    VehiculoService vehiculoService;

    @PostMapping
    ResponseEntity<Vehiculo> create(@RequestBody Vehiculo v) {
        Vehiculo nuevo = vehiculoService.crearVehiculo(v);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevo);
    }

    @GetMapping
    ResponseEntity<List<Vehiculo>> getAll() {
        return ResponseEntity.ok(vehiculoService.getAllVehiculos());
    }

    @GetMapping("/{id}")
    ResponseEntity<Vehiculo> getById(@PathVariable Long id) {
        return ResponseEntity.ok(vehiculoService.getById(id));
    }

    @GetMapping("/sumarPerdidas")
    ResponseEntity<List<PerdidaVehiculoDto>> getPerdidas() {
        return ResponseEntity.ok(vehiculoService.sumarPerdidas());
    }

    @GetMapping("/getPatentePerdida")
    ResponseEntity<List<PatenteMarcaModeloDto>> getPerdidas10000() {
        return ResponseEntity.ok(vehiculoService.findMatriculaYMarcaYModeloBySiniestroWithPerdidaGreaterThan10000());
    }

    @GetMapping("/getPatentes")
    ResponseEntity<List<String>> getPatentes() {
        return ResponseEntity.ok(vehiculoService.findAllPatentes());
    }

    @GetMapping("/getPatentesOrdered")
    ResponseEntity<List<PatenteMarcaDto>> getPatentesOrdered() {
        return ResponseEntity.ok(vehiculoService.findPatenteYMarcaOrderedByAnioFabricacion());
    }

    @GetMapping("/getPatentesThisYear")
    ResponseEntity<List<String>> getPatentesThisYear() {
        return ResponseEntity.ok(vehiculoService.findAllPatentesWithMoreThan4RuedasAndFabricadosThisYear());
    }
}
