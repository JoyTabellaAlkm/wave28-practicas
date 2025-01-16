package com.example.empleadoselasticsearch.controller;

import com.example.empleadoselasticsearch.dto.EmpleadoDto;
import com.example.empleadoselasticsearch.service.IEmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empleado")
public class EmpleadoController {
    @Autowired
    IEmpleadoService service;

    @PostMapping("/add")
    public ResponseEntity<?> createNewEmpleado(@RequestBody EmpleadoDto empleadoDto){
        return new ResponseEntity<>(service.createEmpleado(empleadoDto), HttpStatus.CREATED);
    }
    @GetMapping("/all")
    public ResponseEntity<?> findAllEmpleados(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        List<EmpleadoDto> empleados= service.findAll(page, size);
        return ResponseEntity.ok(empleados);
    }
}
