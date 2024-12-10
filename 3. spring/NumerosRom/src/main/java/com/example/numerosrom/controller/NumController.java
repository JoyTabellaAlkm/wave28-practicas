package com.example.numerosrom.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/demo")
public class NumController {

    @GetMapping("/{numero}")
    public String obtenerNumeroRomano(@PathVariable int numero) {
        if (numero < 1 || numero > 4999) {
            return "Error: El número debe estar entre 1 y 4999.";
        }
        return convertirARomano(numero);
    }

    private String convertirARomano(int numero) {
        String[] miles = {"", "M", "MM", "MMM", "MMMM"};
        String[] centenas = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] decenas = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] unidades = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

        return miles[numero / 1000] +
                centenas[(numero % 1000) / 100] +
                decenas[(numero % 100) / 10] +
                unidades[numero % 10];
    }
}