package com.mercadolibre.edadpersona.controller;

import com.mercadolibre.edadpersona.service.IEdadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/edad")
public class EdadController {

    @Autowired
    IEdadService edadService;

    @GetMapping("/{dia}/{mes}/{anio}")
    public int calcularEdad(@PathVariable int dia,
                            @PathVariable int mes,
                            @PathVariable int anio) {
        return edadService.calcularEdad(dia, mes, anio);
    }
}