package com.spring.ejercicios.Controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import static com.spring.ejercicios.Services.CalculadoraEdadService.calcularEdad;

@RestController
public class CalcularEdadController {

    @GetMapping("/calculadoraEdad/{dia}/{mes}/{anio}")
    public int getEdad(@PathVariable int dia, @PathVariable int mes, @PathVariable int anio) {
        return calcularEdad(dia, mes, anio);
    }
}
