package com.demo.romanify.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/number")
public class NumberController {
    private static final Map<Character, Integer> romanMap = Map.of(
            'M', 1000,
            'D', 500,
            'C', 100,
            'L', 50,
            'X', 10,
            'V', 5,
            'I', 1
    );

    @GetMapping("/roman-to-int/{romanNumber}")
    public int get(@PathVariable String romanNumber) { // tambien podria meterle @Validations
        return convertRomanNumberToInt(romanNumber); // deberiamos llamar a un servicio que tenga esta funcion
    }

    // todo esto puede ir en utils
    public int convertRomanNumberToInt(String romanNumber) {
        romanNumber = romanNumber.toUpperCase();
        int total = 0;
        int prevValue = 0;

        for (int i = romanNumber.length() - 1; i >= 0; i--) {
            int currentValue = romanMap.get(romanNumber.charAt(i));
            total += (currentValue < prevValue) ? -currentValue : currentValue;
            prevValue = currentValue;
        }
        return total;
    }
}
