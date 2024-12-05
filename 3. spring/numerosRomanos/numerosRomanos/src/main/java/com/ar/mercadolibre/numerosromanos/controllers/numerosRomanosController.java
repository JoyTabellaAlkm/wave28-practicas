package com.ar.mercadolibre.numerosromanos.controllers;

import com.ar.mercadolibre.numerosromanos.utils.NumerosRomanos;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/conversion")
public class numerosRomanosController {

    @GetMapping("/aNumeroRomano/{numeroDecimal}")
    public ResponseEntity<String> convertirARomano(@PathVariable Integer numeroDecimal) {
        String numeroRomano = NumerosRomanos.devolverRomano(numeroDecimal);

        if(numeroRomano.equals("Numero invalido")) return ResponseEntity.badRequest().body("Numero invalido");

        return ResponseEntity.ok(numeroRomano);
    }


}
