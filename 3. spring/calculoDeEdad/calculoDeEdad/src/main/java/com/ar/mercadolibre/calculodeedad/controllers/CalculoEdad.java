package com.ar.mercadolibre.calculodeedad.controllers;

import com.ar.mercadolibre.calculodeedad.services.ICalcularEdadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("calculoEdad")
public class CalculoEdad {

//    private final ICalcularEdadService servicio;
//
//    public CalculoEdad(ICalcularEdadService servicio) {
//        this.servicio = servicio;
//    }

    @Autowired
    private ICalcularEdadService servicio;

    @GetMapping("edad/{dia}/{mes}/{anio}")
    public ResponseEntity<Integer> calcularEdad(@PathVariable int dia, @PathVariable int mes, @PathVariable int anio) {
        Integer edad = servicio.calcularEdad(dia, mes, anio);
        if(edad.equals(-1)){
            return ResponseEntity.badRequest().body(401);
        }

        return ResponseEntity.ok().body(edad);
    }
}
