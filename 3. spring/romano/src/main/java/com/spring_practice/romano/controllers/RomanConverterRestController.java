package com.spring_practice.romano.controllers;

import com.github.chaosfirebolt.converter.RomanInteger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/roman")
public class RomanConverterRestController {

    @GetMapping("/v1/{number}")
    public String convertToRomanV1(@PathVariable Integer number) {
        if (number < 1 || number > 3999) {
            return "Por favor ingrese un numero dentro del rango 1-3999";
        }
        RomanInteger convertedNumber = RomanInteger.parse(number.toString());
        return convertedNumber.toString();
    }

    @GetMapping("/v2/{number}")
    public String convertToRomanV2(@PathVariable Integer number) {
        StringBuilder romanNumber = new StringBuilder();
        int[] numbersToCompare = {1000,900,500,400,100,90,50,40,10, 9, 5, 4, 1};
        String[] romanNumbers = {"M","CM","D","CD","C","XC","L","XL", "X", "IX", "V", "IV", "I"};

        for (int i = 0; i < numbersToCompare.length; i++)
            for (;number >= numbersToCompare[i]; number -= numbersToCompare[i])
                romanNumber.append(romanNumbers[i]);

        return romanNumber.toString();
    }

    @GetMapping("/v3/{number}")
    public String convertToRomanV3(@PathVariable Integer number) {
        StringBuilder romanNumber = new StringBuilder();
        int[] numbersToCompare = {1000,900,500,400,100,90,50,40,10, 9, 5, 4, 1};
        String[] romanNumbers = {"M","CM","D","CD","C","XC","L","XL", "X", "IX", "V", "IV", "I"};
        int currentPos = 0;
        while(number > 0) {
            if(number >= numbersToCompare[currentPos]) {
                number -= numbersToCompare[currentPos];
                romanNumber.append(romanNumbers[currentPos]);
                continue;
            }
            currentPos++;
        }
        return romanNumber.toString();
    }
}
