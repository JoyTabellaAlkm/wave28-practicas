package com.ejercicio.numerosromanos.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ejercicio.numerosromanos.services.numerosRomanos;

@RestController
@RequestMapping("/romanos")
public class NumerosRomanosController {

    @GetMapping("numero/{number}")
    public String convertirDecimalARomano(@PathVariable Integer number){
        return numerosRomanos.aNumeroRomano(number);
    }
}
