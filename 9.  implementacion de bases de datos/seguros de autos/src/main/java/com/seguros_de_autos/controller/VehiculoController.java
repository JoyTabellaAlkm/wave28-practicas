package com.seguros_de_autos.controller;

import com.seguros_de_autos.DTO.VehiculoDto;
import com.seguros_de_autos.DTO.VehiculoPatentesResponseDto;
import com.seguros_de_autos.DTO.VehiculoResponseDto;
import com.seguros_de_autos.service.IVehiculoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/seguros")
public class VehiculoController {

    @Autowired
    private IVehiculoService vehiculoService;

    @PostMapping("/vehiculos")
    public ResponseEntity<VehiculoResponseDto> createVehiculo(@RequestBody @Valid VehiculoDto vehiculo){
        return ResponseEntity.ok(vehiculoService.createVehiculo(vehiculo));
    }

    @GetMapping("/patentes")
    public ResponseEntity<VehiculoPatentesResponseDto> getPatentes(){
        return ResponseEntity.ok(vehiculoService.getPatentes());
    }
}
