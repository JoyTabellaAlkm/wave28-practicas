package com.numerosRomanos.numerosRomanos.controllers;

import com.numerosRomanos.numerosRomanos.services.NumerosRomanosService;
import org.springframework.web.bind.annotation.*;

@RestController
public class NumerosRomanosController {
    private NumerosRomanosService nromanoServices = new NumerosRomanosService();

    @GetMapping("/obtenerConversion")
    public String obtenerNumeroRomano(@RequestParam int numero){
        return nromanoServices.convertirANumeroRomano(numero);
    }

    @GetMapping("/obtenerConversion/{romano}")
    public String obtenerNumeroRomano(@PathVariable String romano){
        return romano;
    }


}
