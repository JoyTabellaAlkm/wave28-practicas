package com.ar.mercadolibre.empleados.controller;

import com.ar.mercadolibre.empleados.dto.EmpleadoDTO;
import com.ar.mercadolibre.empleados.service.IEmpleadoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/empleados")
public class EmpleadoController {

    private final IEmpleadoService empleadoService;

    public EmpleadoController(IEmpleadoService empleadoService) {
        this.empleadoService = empleadoService;
    }

    @PostMapping("/alta")
    public ResponseEntity<EmpleadoDTO> crearEmpleado(@RequestBody EmpleadoDTO empleadoDTO) {
        return new ResponseEntity<>(empleadoService.crear(empleadoDTO), HttpStatus.CREATED);
    }

    @PutMapping("/modificacion/{id}")
    public ResponseEntity<EmpleadoDTO> modificarEmpleado(@PathVariable String id, @RequestBody EmpleadoDTO empleadoDTO) {
        return new ResponseEntity<>(empleadoService.modificar(id, empleadoDTO), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<EmpleadoDTO>> traerTodosLosEmpleados() {
        return new ResponseEntity<>(empleadoService.traerTodos(), HttpStatus.OK);
    }


}
