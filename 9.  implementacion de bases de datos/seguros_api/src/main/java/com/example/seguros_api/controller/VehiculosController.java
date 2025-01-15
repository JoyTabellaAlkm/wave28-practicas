package com.example.seguros_api.controller;

import com.example.seguros_api.dto.RequestVehiculoDto;
import com.example.seguros_api.service.IVehiculosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("vehiculos")
public class VehiculosController {
    @Autowired
    private IVehiculosService vehiculosService;

    @PostMapping("new")
    public ResponseEntity<?> create(@RequestBody RequestVehiculoDto requestTestCaseDto){
        return new ResponseEntity<>(vehiculosService.create(requestTestCaseDto), HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<?> index(){
        return new ResponseEntity<>(vehiculosService.getAll(), HttpStatus.OK);
    }
}
