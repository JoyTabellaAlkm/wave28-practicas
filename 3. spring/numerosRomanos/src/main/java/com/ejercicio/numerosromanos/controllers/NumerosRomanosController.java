package com.ejercicio.numerosromanos.controllers;

import com.ejercicio.numerosromanos.services.NumerosRomanosService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/romanos")
public class NumerosRomanosController {

    private final NumerosRomanosService servicio = new NumerosRomanosService();

    @GetMapping("numero/{number}")
    public String convertirDecimalARomano(@PathVariable Integer number){
        return servicio.aNumeroRomano(number);
    }
}
