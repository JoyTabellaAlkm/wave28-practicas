package com.numerosromanos.convertir.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NumerosController {

    @GetMapping("/convert")
    public String convertRoman (@RequestParam int number){
        if (number <= 0 || number > 3999) {
            return "Error: Please enter a number between 1 and 3999.";
        }
        return "Roman numeral: " + toRoman(number);
    }

    private String toRoman(int number) {
        StringBuilder roman = new StringBuilder();
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        for (int i = 0; i < values.length; i++) {
            while (number >= values[i]) {
                number -= values[i];
                roman.append(symbols[i]);
            }
        }

        return roman.toString();
    }

}
