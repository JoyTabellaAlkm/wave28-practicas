package com.example.calcularedad.controller;

import com.example.calcularedad.service.EdadService;
import com.example.calcularedad.service.impl.EdadServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/edad")
public class EdadController {

    @Autowired
    private EdadServiceImpl edadService;

    @GetMapping("{dia}/{mes}/{anio}")
    public String calcularEdad(@PathVariable Integer dia, @PathVariable Integer mes, @PathVariable Integer anio){

        return edadService.calcularEdad(dia, mes, anio);
    }
}
