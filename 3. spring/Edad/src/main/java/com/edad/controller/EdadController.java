package com.edad.controller;

import com.edad.service.EdadService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/")
public class EdadController {
    @GetMapping("{dia}/{mes}/{anio}")
    public Map<String, String> CalcularEdad(@PathVariable int dia, @PathVariable int mes, @PathVariable int anio) {
        String edad = String.valueOf(EdadService.CalcularEdad(dia, mes, anio));

        if (edad.equals("-1")) {
            return Map.of("Edad no se puede calcular", "Ingrese fecha de nacimiento valida");
        }
        return Map.of("Edad: ", edad);

    }
}