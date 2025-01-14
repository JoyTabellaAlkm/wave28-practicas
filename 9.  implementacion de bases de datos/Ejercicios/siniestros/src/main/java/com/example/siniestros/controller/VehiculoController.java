package com.example.siniestros.controller;

import com.example.siniestros.service.IVehiculoService;
import com.example.siniestros.service.VehiculoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vehiculos")
public class VehiculoController {

    @Autowired
    IVehiculoService vehiculoService;

    @GetMapping("/patentes")
    public ResponseEntity<?> getPatentes(){
        return new ResponseEntity<>(vehiculoService.getPatentes(), HttpStatus.OK);
    }

    @GetMapping("/patente&marca")
    public ResponseEntity<?> getPatenteMarca(){
        return new ResponseEntity<>(vehiculoService.getPatenteMarca(),HttpStatus.OK);
    }

    @GetMapping("/patenteByCantRuedasAñoFabricacion")
    public ResponseEntity<?> getPatenteByCantRuedasAñoFabricacion(){
        return new ResponseEntity<>(vehiculoService.getPatenteByCantRuedasAndAñoFabricacion(),HttpStatus.OK);
    }
}
