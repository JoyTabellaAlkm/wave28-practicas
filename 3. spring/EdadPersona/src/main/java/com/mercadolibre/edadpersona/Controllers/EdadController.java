package com.mercadolibre.edadpersona.controllers;

import com.mercadolibre.edadpersona.services.IEdadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EdadController {

    @Autowired
    IEdadService servicio;

    @GetMapping("/{dia}/{mes}/{ano}")
    public Integer getEdad(@PathVariable int dia, @PathVariable int mes, @PathVariable int ano){
        return servicio.calcularEdad(dia, mes, ano);
    }
}
