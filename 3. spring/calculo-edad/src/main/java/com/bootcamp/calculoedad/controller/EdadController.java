package com.bootcamp.calculoedad.controller;


import com.bootcamp.calculoedad.service.IEdadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("edad")
public class EdadController {
    @Autowired
    IEdadService edadService;


    @GetMapping("{dia}/{mes}/{anio}")
    public String calcularEdad(@PathVariable Integer dia, @PathVariable Integer mes, @PathVariable Integer anio) {
        try {
            return edadService.calcularEdad(dia, mes, anio);
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
