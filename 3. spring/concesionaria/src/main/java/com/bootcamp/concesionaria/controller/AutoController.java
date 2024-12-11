package com.bootcamp.concesionaria.controller;

import com.bootcamp.concesionaria.dto.VehiculoDto;
import com.bootcamp.concesionaria.service.IVehiculoService;
import com.bootcamp.concesionaria.service.impl.VehiculoServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/v1/api/vehicles")
public class AutoController {

    IVehiculoService vehiculoService;

    public AutoController(VehiculoServiceImpl vehiculoService) {
        this.vehiculoService = vehiculoService;
    }

    @PostMapping()
    public ResponseEntity<?> createVehiculo(@RequestBody VehiculoDto vehiculoDto){
        vehiculoService.saveVehiculo(vehiculoDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(vehiculoDto);
    }

    @GetMapping()
    public ResponseEntity<?> getVehiculos(){
        return ResponseEntity.ok().body(vehiculoService.searchAll());
    }

    @GetMapping("/dates")
    public ResponseEntity<?> getVehiculoByFechaFabricacion(@RequestParam LocalDate since,
                                                           @RequestParam LocalDate to){
        return ResponseEntity.ok().body(vehiculoService.searchVehiculosByFechaFabricacion(since, to));
    }

    @GetMapping("/prices")
    public ResponseEntity<?> getVehiculoByPrecio(@RequestParam Integer since,
                                                 @RequestParam Integer to){
        return ResponseEntity.ok().body(vehiculoService.searchVehiculosByPrecio(since, to));
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getVehiculoById(@PathVariable Long id){
        return ResponseEntity.ok().body(vehiculoService.searchVehiculoById(id));
    }

}
