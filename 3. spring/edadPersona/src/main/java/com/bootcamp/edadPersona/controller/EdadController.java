package com.bootcamp.edadPersona.controller;

import com.bootcamp.edadPersona.service.impl.EdadServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class EdadController {
    @Autowired
    EdadServiceImpl edadService;
    @GetMapping("/edad/{dia}/{mes}/{anio}")
    public String getEdadPersona (@PathVariable int dia,
                                   @PathVariable int mes,
                                   @PathVariable int anio) {

        String edad = edadService.calcularEdad(dia,mes,anio);
        return edad;
    }

}
