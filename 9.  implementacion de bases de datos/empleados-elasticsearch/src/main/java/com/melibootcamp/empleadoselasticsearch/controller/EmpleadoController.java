package com.melibootcamp.empleadoselasticsearch.controller;

import com.melibootcamp.empleadoselasticsearch.entity.Empleado;
import com.melibootcamp.empleadoselasticsearch.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/empleados")
public class EmpleadoController {

    @Autowired
    private EmpleadoService empleadoService;

    @PostMapping()
    public ResponseEntity<?> save (@RequestBody Empleado artic) {
        return new ResponseEntity<>(empleadoService.save(artic), HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<?> findAll () {

        return new ResponseEntity<>(empleadoService.findAll(), HttpStatus.OK);
    }

    @GetMapping ("/{id}")
    //va optional porque puede que devuelva como puede que no
    public ResponseEntity<?> findById(@PathVariable String id) {
        return new ResponseEntity<>(empleadoService.findById(id),HttpStatus.OK);
    }

    @DeleteMapping ("/{id}")
    public ResponseEntity<?> deleteEmpleado (@PathVariable String id) {

        return new ResponseEntity<>(empleadoService.delete(id), HttpStatus.OK);
    }

    @PutMapping ("/{id}")
    public ResponseEntity<?> editEmpleado (@RequestBody Empleado obra, @PathVariable String id) {

        return new ResponseEntity<>(empleadoService.update(obra, id), HttpStatus.OK);
    }

}
