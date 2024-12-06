package org.ejercicios.ejerciciosspring.controller;

import org.ejercicios.ejerciciosspring.service.ICalculadoraEdad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculadoraEdadController {


    @Autowired
    private ICalculadoraEdad calculadoraService;

    @GetMapping("/calculadoraEdad/{dia}/{mes}/{anio}")
    public int getEdad(@PathVariable int dia, @PathVariable int mes, @PathVariable int anio) {
        return calculadoraService.calcularEdad(dia, mes, anio);
    }

}
