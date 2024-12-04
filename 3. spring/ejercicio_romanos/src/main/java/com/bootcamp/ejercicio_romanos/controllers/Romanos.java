package com.bootcamp.ejercicio_romanos.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class Romanos {
    @GetMapping("/romanos/{decimal}")
    public String getRomano(@PathVariable Integer decimal){
        StringBuilder resultadoRomano = new StringBuilder();
        int[] numbers = {1000,900,500,400,100,90,50,40,10, 9, 5, 4, 1};
        String[] numerosRomano = {"M","CM","D","CD","C","XC","L","XL", "X", "IX", "V", "IV", "I"};

        for (int i = 0; i < numbers.length; i++){
            while (decimal >= numbers[i]){
                resultadoRomano.append(numerosRomano[i]);
                decimal -= numbers[i];
            }
            if(decimal== 0){
                break;
            }
        }

        return resultadoRomano.toString();
    }
}
