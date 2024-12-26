package com.bootcamp.ejercicio1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RomanController {

    @GetMapping("/convert/{number}")
    public String toRoman(@PathVariable Integer number) {
        StringBuilder stringBuilder = new StringBuilder();
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] chars = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        int i = 0;
        while(number > 0) {
            if (number >= values[i]) {
                stringBuilder.append(chars[i]);
                number = number - values[i];
            }
            else {
                i++;
            }
        }

        return stringBuilder.toString();
    }

}