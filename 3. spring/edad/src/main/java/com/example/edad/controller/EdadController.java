package com.example.edad.controller;

import com.example.edad.service.IEdadService;
import com.example.edad.service.implement.EdadServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EdadController {
    @Autowired
    private IEdadService edadService;

    @GetMapping("/edad/{dia}/{mes}/{anio}")
    public String getEdadPersona(@PathVariable int dia, @PathVariable int mes, @PathVariable int  anio){
        return edadService.calcularEdad(dia, mes, anio);
    }
}

