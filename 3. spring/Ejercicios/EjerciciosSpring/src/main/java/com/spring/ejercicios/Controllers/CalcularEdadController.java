package com.spring.ejercicios.Controllers;

import com.spring.ejercicios.Services.iCalculadoraEdadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalcularEdadController {

    @Autowired
    private iCalculadoraEdadService edadService;

    @GetMapping("/calculadoraEdad/{dia}/{mes}/{anio}")
    public int getEdad(@PathVariable int dia, @PathVariable int mes, @PathVariable int anio) {
        return edadService.calcularEdad(dia, mes, anio);
    }
}
