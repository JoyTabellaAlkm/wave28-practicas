package com.ar.mercadolibre.calculodeedad.controllers;

import com.ar.mercadolibre.calculodeedad.services.CalcularEdadServiceImpl;
import com.ar.mercadolibre.calculodeedad.services.ICalcularEdadService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("calculoEdad")
public class CalculoEdad {

    private final ICalcularEdadService servicio;

    public CalculoEdad() {
        this.servicio = new CalcularEdadServiceImpl();
    }

    @GetMapping("edad/{dia}/{mes}/{anio}")
    public ResponseEntity<Integer> calcularEdad(@PathVariable int dia, @PathVariable int mes, @PathVariable int anio) {

        return ResponseEntity.ok(servicio.calcularEdad(dia, mes, anio));
    }
}
