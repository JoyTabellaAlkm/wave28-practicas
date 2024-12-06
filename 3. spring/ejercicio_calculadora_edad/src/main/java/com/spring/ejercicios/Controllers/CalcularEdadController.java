package com.spring.ejercicios.Controllers;

import com.spring.ejercicios.Services.CalculadoraEdadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalcularEdadController {

    @Autowired
    private CalculadoraEdadService edadService;

    @GetMapping("/calculadoraEdad/{dia}/{mes}/{anio}")
    public int getEdad(@PathVariable int dia, @PathVariable int mes, @PathVariable int anio) {
        return edadService.calcularEdad(dia, mes, anio);
    }
}
