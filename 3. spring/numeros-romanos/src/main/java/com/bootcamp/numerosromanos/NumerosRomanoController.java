package com.bootcamp.numerosromanos;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class NumerosRomanoController {
    NumeroRomanoService numeroRomanoService = new NumeroRomanoService();


    @GetMapping("conversorNumerosRomanos/decimal/{numero}")
    public String getNumeroRomanoDeDecimal(@PathVariable int numero) {
        return numeroRomanoService.convertirDecimalANumeroRomano(numero);
    }
}
