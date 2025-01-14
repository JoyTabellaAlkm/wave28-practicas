package com.elasticsearch.usuarios.controller;

import com.elasticsearch.usuarios.model.Empleado;
import com.elasticsearch.usuarios.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empleados")
public class EmpleadoController {

    @Autowired
    EmpleadoService empleadoService;

    @PostMapping
    ResponseEntity<Void> create(@RequestBody Empleado emp) {
        empleadoService.crearEmpleado(emp);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    ResponseEntity<List<Empleado>> getAll() {
        return ResponseEntity.ok(empleadoService.getAllEmpleados());
    }
}
