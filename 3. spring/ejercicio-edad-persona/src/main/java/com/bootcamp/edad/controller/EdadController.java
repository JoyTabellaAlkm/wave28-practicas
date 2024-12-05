package com.bootcamp.edad.controller;

import com.bootcamp.edad.service.EdadService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/edad")
public class EdadController {

    @GetMapping("/{dia}/{mes}/{anio}")
    public int getEdad(@PathVariable int dia,
                       @PathVariable int mes,
                       @PathVariable int anio) {
        return EdadService.calcularEdad(dia, mes, anio);
    }

}
