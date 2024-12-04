package com.bootcamp.java.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class ConvertirNumerosRomanosController {

    @GetMapping("/convertir/{numero}")
    public String saludarConPathVarieble(@PathVariable Integer numero) {
        int[] numDecimales = {1000,900,500,400,100,90,50,40,10, 9, 5, 4, 1};
        String[] numRomanos = {"M","CM","D","CD","C","XC","L","XL", "X", "IX", "V", "IV", "I"};
        StringBuilder romano = new StringBuilder();

        for (int i=0; i< numRomanos.length; i++){
            while (numero >= numDecimales[i]){
                numero -= numDecimales[i];
                romano.append(numRomanos[i]);
            }
        }
        return romano.toString();
    }
}
