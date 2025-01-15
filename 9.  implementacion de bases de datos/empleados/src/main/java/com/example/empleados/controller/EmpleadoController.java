package com.example.empleados.controller;

import com.example.empleados.model.Empleado;
import com.example.empleados.service.IEmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmpleadoController {

    private IEmpleadoService empleadoService;

    @Autowired
    public EmpleadoController(IEmpleadoService empleadoService) {
        this.empleadoService = empleadoService;
    }

    @PostMapping("/empleado")
    public ResponseEntity<Empleado> createEmpleado(@RequestBody Empleado empleado){
        return new ResponseEntity<>(empleadoService.createEmpleado(empleado), HttpStatus.CREATED);
    }

    @GetMapping("/empleado")
    public ResponseEntity<List<Empleado>> getEmpleadosByName(@RequestParam String nombre) {
        return new ResponseEntity<>(empleadoService.findByNombre(nombre), HttpStatus.OK);
    }
}
