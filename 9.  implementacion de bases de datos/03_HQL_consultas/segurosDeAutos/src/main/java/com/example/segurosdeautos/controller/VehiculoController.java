package com.example.segurosdeautos.controller;

import com.example.segurosdeautos.dto.request.VehiculoRequestDto;
import com.example.segurosdeautos.dto.response.VehiculoResponseDto;
import com.example.segurosdeautos.service.IVehiculoService;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.HTML;
import java.util.List;

@RestController
@RequestMapping("/api/vehiculos")
public class VehiculoController {

    private final IVehiculoService vehiculoService;

    public VehiculoController(IVehiculoService vehiculoService){
        this.vehiculoService = vehiculoService;
    }

    @PostMapping("/new")
    @Transactional
    public ResponseEntity<VehiculoResponseDto> crearVehiculo(@RequestBody VehiculoRequestDto vehiculo){
        return new ResponseEntity<>(vehiculoService.crearVehiculo(vehiculo), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<VehiculoResponseDto>> obtenerTodosLosVehiculos(){
        return new ResponseEntity<>(vehiculoService.obtenerTodosLosVehiculos(),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerVehiculoPorId(@PathVariable Long id){
        return  new ResponseEntity<>(vehiculoService.obtenerVehiculoPorId(id), HttpStatus.OK);
    }
}
