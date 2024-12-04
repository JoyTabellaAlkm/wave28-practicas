package com.numerosRomanos.meli.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class NumeroController {

    @GetMapping("/cambio/{number}")
    public String cambioNumeroDecimalRomano(@PathVariable int number) {
        int[] vaNum = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

        String[] vaRom = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        String res ="";
        int aux=number;
        int i = 0;
        if (number == 0) {
            return "";
        }
        while(aux>0){
            if(aux>= vaNum[i]){
                res= res + vaRom[i];
                aux = aux - vaNum[i];
            }
            else {
                i++;
            }

        }
        return res;
    }
}
