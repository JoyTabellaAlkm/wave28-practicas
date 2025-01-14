package com.melibootcamp.empresadeseguros.controller;

import com.melibootcamp.empresadeseguros.entity.Vehiculo;
import com.melibootcamp.empresadeseguros.service.VehiculoServiceImpl;
import com.melibootcamp.empresadeseguros.service.interfaces.IVehiculoService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/vehiculos")
public class VehiculoController {

    private IVehiculoService vehiculoService;

    public VehiculoController(VehiculoServiceImpl vehiculoServiceImpl){
        this.vehiculoService = vehiculoServiceImpl;
    }

    @GetMapping("/all")
    public ResponseEntity<?> getVehiculos(){
        return new ResponseEntity<>(vehiculoService.getVehiculos(), HttpStatus.OK);
    }

    @PostMapping("/new")
    public ResponseEntity<?> saveVehiculo(
            @RequestBody Vehiculo vehiculo)
    {
        return new ResponseEntity<>(vehiculoService.saveVehiculo(vehiculo), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getVehiculoById(
            @PathVariable long id)
    {
        return new ResponseEntity<>(vehiculoService.getVehiculoById(id), HttpStatus.OK);
    }

    @GetMapping("patentes")
    public ResponseEntity<?> getVehiculosByPatentes(){
        return new ResponseEntity<>(vehiculoService.getPatentes(), HttpStatus.OK);
    }

    @GetMapping("fabricacion")
    public ResponseEntity<?> getMarcaAndPatenteByFabricacion(){
        return new ResponseEntity<>(vehiculoService.getPatenteAndMarca(), HttpStatus.OK);
    }

    @GetMapping("siniestroMayorA10000")
    public ResponseEntity<?> getVehiculosMayorA10000(){
        return new ResponseEntity<>(vehiculoService.getVehiculosConPerdidaMayorA10000(), HttpStatus.OK);
    }

    @GetMapping("4RuedasYEsteAño")
    public ResponseEntity<?> getPatenteEsteAñoy4Ruedas(){
        return new ResponseEntity<>(vehiculoService.findPatentesWhereMasDe4RuedasAndFabricadosEsteAño(), HttpStatus.OK);
    }

}
