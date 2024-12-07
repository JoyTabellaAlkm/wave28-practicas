package com.mercadolibre.romannumeral.service;

import org.springframework.stereotype.Service;

@Service
public class RomanNumeralService {

    public String convertToRoman(Integer number){
        StringBuilder romanNumber = new StringBuilder();
        int[] numbersToCompare = {1000,900,500,400,100,90,50,40,10, 9, 5, 4, 1};
        String[] romanNumbers = {"M","CM","D","CD","C","XC","L","XL", "X", "IX", "V", "IV", "I"};

        for (int i = 0; i < numbersToCompare.length; i++) {
            for (; number >= numbersToCompare[i]; number -= numbersToCompare[i]) {
                romanNumber.append(romanNumbers[i]);
            }
            if (number == 0) break;
        }

        return romanNumber.toString();
    }
}
