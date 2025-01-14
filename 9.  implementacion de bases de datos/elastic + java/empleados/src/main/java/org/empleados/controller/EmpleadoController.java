package org.empleados.controller;

import org.empleados.domain.Empleado;
import org.empleados.service.EmpleadosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmpleadoController {

    @Autowired
    private EmpleadosService service;

    @PostMapping("/add")
    public ResponseEntity<Empleado> post(@RequestBody Empleado e) {
        return new ResponseEntity<>(service.add(e), HttpStatus.CREATED);
    }

    @PutMapping("/edit")
    public ResponseEntity<Empleado> put(@RequestBody Empleado e) {
        return new ResponseEntity<>(service.edit(e), HttpStatus.OK);
    }
}
