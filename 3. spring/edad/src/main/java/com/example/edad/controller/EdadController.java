package com.example.edad.controller;

import com.example.edad.service.EdadService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EdadController {
    private EdadService edadService = new EdadService();

    @GetMapping("/edad/{dia}/{mes}/{anio}")
    public int getEdadPersona(@PathVariable int dia, @PathVariable int mes, @PathVariable int  anio){
        return edadService.calcularEdad(dia, mes, anio);
    }
}
