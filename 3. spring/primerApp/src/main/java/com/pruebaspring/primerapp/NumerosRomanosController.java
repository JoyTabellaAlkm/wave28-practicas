package com.pruebaspring.primerapp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NumerosRomanosController {
    @GetMapping("/convertirARomano/{number}")
    public String convertirDecimalARomano(@PathVariable int number){
        if(number<=10){
            return "El numero " + number +" corresponde a " + romano(number);
        }
        return "No es posible convertir";
    }

    public String romano(int decimal){
        
        if(decimal<4){
            return "I".repeat(decimal);
        }else if(decimal==4){
            return "IV";
        } else if (decimal ==5) {
            return "V";
        } else if (decimal>5 && decimal<9) {
            return "V"+"I".repeat(decimal-5);
        } else if (decimal==9) {
            return "IX";
        }else if(decimal == 10){
            return "X";
        }
        return "";
    }
}
