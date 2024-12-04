package com.mercadolibre.numerosromanos;

import org.springframework.web.bind.annotation.*;

@RestController
public class ConversorController {

    @GetMapping("/convertir/{numero}")
    public String convertir(@PathVariable int numero) {
        return convertirDecimalARomano(numero);
    }

    public String convertirDecimalARomano(int numero) {
        int[] decimales = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romanos = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder resultado = new StringBuilder();

        for (int i = 0; i < decimales.length; i++) {
            while (numero >= decimales[i]) {
                numero -= decimales[i];
                resultado.append(romanos[i]);
            }
        }

        return resultado.toString();
    }
}


