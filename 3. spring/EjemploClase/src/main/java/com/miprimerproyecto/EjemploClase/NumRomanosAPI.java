package com.miprimerproyecto.EjemploClase;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NumRomanosAPI {

    @GetMapping("/numRomano/{num}")
    public String GetNumRomano(@PathVariable int num){

        String numRomaDevolver="";

        int[] numDecimal={1, 2, 3,4, 5, 7, 10, 13, 50, 100, 500,1000};
        String[] sNumRomanos= {"I", "II", "III","IV","V","VII","X","XIII", "L","C","D","M"};


        for(var i = 0; i <= numDecimal.length; i++){
            if (numDecimal[i] == num) {
                numRomaDevolver= sNumRomanos[i];
                break;
            }
        }


        return numRomaDevolver;

    }

}
