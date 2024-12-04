package com.melibootcamp.romannumbers.repositories;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class RomanNumbersRepository {

    private int[] numbersToCompare = {1000,900,500,400,100,90,50,40,10, 9, 5, 4, 1};
    private String[] romanNumbers = {"M","CM","D","CD","C","XC","L","XL", "X", "IX", "V", "IV", "I"};

    public Optional<String> decimalToRoman(int toConvert){
        // SORT THE DICTIONARY
        Optional<String> toReturn = Optional.empty();
        String roman = "";
        while(toConvert != 0){
            for (int i = 0; i<numbersToCompare.length; i++) {
                int value = numbersToCompare[i];
                String romanNumber = romanNumbers[i];
                if (toConvert >= value) {
                    roman += romanNumber;
                    toConvert -= value;
                    break;
                }
            }
        }
        toReturn = Optional.of(roman);
        return toReturn;
    }
}
