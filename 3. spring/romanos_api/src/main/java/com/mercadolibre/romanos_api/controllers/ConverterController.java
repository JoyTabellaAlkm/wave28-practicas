package com.mercadolibre.romanos_api.controllers;

import com.mercadolibre.romanos_api.enums.RomanSymbols;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/converter")
public class ConverterController {

    private String convert(int number) {
        if (number == 0) {
            return null;
        }

        StringBuilder converted = new StringBuilder();
        RomanSymbols symbol = null;
        int repeatSymbol = 0;
        while (number != 0) {
            if (number >= 1000) {
                symbol = RomanSymbols.M;
                repeatSymbol = number / 1000;
                number = number % 1000;
            } else if (number >= 500) {
                if (number >= 900) {
                    symbol = RomanSymbols.CM;
                    repeatSymbol = 1;
                    number = number % 900;
                } else {
                    symbol = RomanSymbols.D;
                    repeatSymbol = number / 500;
                    number = number % 500;
                }
            } else if (number >= 100) {
                if (number >= 400) {
                    symbol = RomanSymbols.CD;
                    repeatSymbol = 1;
                    number = number % 400;
                } else {
                    symbol = RomanSymbols.C;
                    repeatSymbol = number / 100;
                    number = number % 100;
                }
            } else if (number >= 50) {
                if (number >= 90) {
                    symbol = RomanSymbols.XC;
                    repeatSymbol = 1;
                    number = number % 90;
                } else {
                    symbol = RomanSymbols.L;
                    repeatSymbol = number / 50;
                    number = number % 50;
                }
            } else if (number >= 10) {
                if (number >= 40) {
                    symbol = RomanSymbols.XL;
                    repeatSymbol = 1;
                    number = number % 40;
                } else {
                    symbol = RomanSymbols.X;
                    repeatSymbol = number / 10;
                    number = number % 10;
                }
            } else if (number >= 5) {
                if (number == 9) {
                    symbol = RomanSymbols.IX;
                    repeatSymbol = 1;
                    number = 0;
                } else {
                    symbol = RomanSymbols.V;
                    repeatSymbol = number / 5;
                    number = number % 5;
                }
            } else {
                if (number == 4) {
                    symbol = RomanSymbols.IV;
                    repeatSymbol = 1;
                } else {
                    symbol = RomanSymbols.I;
                    repeatSymbol = number;
                }

                number = 0;
            }

            converted.repeat(symbol.toString(), repeatSymbol);
        }

        return converted.toString();
    }

    @GetMapping("/arabic-to-roman/{number}")
    public Object arabicToRoman(@PathVariable int number) {
        Map<String, Object> res = new HashMap<>();
        res.put("number", convert(number));

        return res;
    }

}
