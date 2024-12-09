package com.bootcamp.ejercicio_edad.Controllers;

import com.bootcamp.ejercicio_edad.Services.IEdadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EdadController {

    @Autowired
    private IEdadService edadService;

    @GetMapping("/{dia}/{mes}/{anio}")
    public Integer getEdad(@PathVariable int dia, @PathVariable int mes, @PathVariable int anio){
        return edadService.calcularEdad(dia, mes, anio);
    }
}
