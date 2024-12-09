package com.bootcamp.concesionaria.controller;

import com.bootcamp.concesionaria.dto.VehiculoDTO;
import com.bootcamp.concesionaria.dto.VehiculoUsadoDTO;
import com.bootcamp.concesionaria.exception.NotFoundException;
import com.bootcamp.concesionaria.service.VehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/v1/api/vehicles")
public class VehiculoController {

    @Autowired
    private VehiculoService vehiculoService;

    @PostMapping
    public ResponseEntity<?> crear(@RequestBody VehiculoDTO vehiculo) {
        try {
            vehiculoService.create(vehiculo);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping
    public ResponseEntity<List<VehiculoUsadoDTO>> getVehiculosUsados() {
        return ResponseEntity.ok(vehiculoService.getUsados());
    }

    @GetMapping("/dates")
    public ResponseEntity<List<VehiculoDTO>> getBetweenFecha(
            @RequestParam @DateTimeFormat(pattern = "dd/mm/yyyy") LocalDate since,
            @RequestParam @DateTimeFormat(pattern = "dd/mm/yyyy") LocalDate to) {
        return ResponseEntity.ok(vehiculoService.getManufacturedBetween(since, to));
    }

    @GetMapping("/prices")
    public ResponseEntity<List<VehiculoDTO>> getBetweenFecha(
            @RequestParam Double since,
            @RequestParam Double to) {
        return ResponseEntity.ok(vehiculoService.getBetweeenPrice(since, to));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> crear(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(vehiculoService.getById(id));
        } catch (NotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
