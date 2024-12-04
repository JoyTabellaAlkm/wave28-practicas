package com.bootcamp.numeros_romanos.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class NumerosRomanosController {

    @GetMapping("/numeroRomano/{numeroDecimal}")
    public String numeroRomano(@PathVariable int numeroDecimal) {
        return "El número decimal " + numeroDecimal + " representado en números romanos es: " + convertToRoman(numeroDecimal);
    }

    private String convertToRoman(int numeroDecimal) {
        if(numeroDecimal >= 1000) {return "M"  + convertToRoman(numeroDecimal - 1000);}
        if(numeroDecimal >=  900) {return "CM" + convertToRoman(numeroDecimal -  900);}
        if(numeroDecimal >=  500) {return "D"  + convertToRoman(numeroDecimal -  500);}
        if(numeroDecimal >=  400) {return "CD" + convertToRoman(numeroDecimal -  400);}
        if(numeroDecimal >=  100) {return "C"  + convertToRoman(numeroDecimal -  100);}
        if(numeroDecimal >=   90) {return "XC" + convertToRoman(numeroDecimal -   90);}
        if(numeroDecimal >=   50) {return "L"  + convertToRoman(numeroDecimal -   50);}
        if(numeroDecimal >=   40) {return "XL" + convertToRoman(numeroDecimal -   40);}
        if(numeroDecimal >=   10) {return "X"  + convertToRoman(numeroDecimal -   10);}
        if(numeroDecimal >=    9) {return "IX" + convertToRoman(numeroDecimal -    9);}
        if(numeroDecimal >=    5) {return "V"  + convertToRoman(numeroDecimal -    5);}
        if(numeroDecimal >=    4) {return "IV" + convertToRoman(numeroDecimal -    4);}
        if(numeroDecimal >=    1) {return "I"  + convertToRoman(numeroDecimal -    1);}

        return "";
    }

}
