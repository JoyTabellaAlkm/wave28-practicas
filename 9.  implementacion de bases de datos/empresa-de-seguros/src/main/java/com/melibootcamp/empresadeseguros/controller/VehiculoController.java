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

    //---

    @GetMapping("/hql-1")
    public ResponseEntity<?> getPatentesRegistradas(){
        return new ResponseEntity<>(vehiculoService.getPatentesRegistradas(), HttpStatus.OK);
    }

    @GetMapping("/hql-2")
    public ResponseEntity<?> getPatentesYMarcasEnOrden(){
        return new ResponseEntity<>(vehiculoService.getMarcaYPatentesEnOrden(), HttpStatus.OK);
    }


}
