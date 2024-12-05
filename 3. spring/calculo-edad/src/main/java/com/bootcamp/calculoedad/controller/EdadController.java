package com.bootcamp.calculoedad.controller;


import com.bootcamp.calculoedad.service.EdadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EdadController {
    @Autowired
    EdadService edadService;


    @GetMapping("edad/{dia}/{mes}/{anio}")
    public Integer calcularEdad(@PathVariable Integer dia, @PathVariable Integer mes, @PathVariable Integer anio) {
        try {
            return edadService.calcularEdad(dia, mes, anio);
        } catch (Exception e) {
            return 0;
        }
    }
}
