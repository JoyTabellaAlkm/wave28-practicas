package com.bootcamp.meli.numeroRomanos.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.awt.image.VolatileImage;
import java.util.HashMap;
import java.util.Map;

@RestController
public class NumbersController {

    @GetMapping(path = "/numero/{numero}")
    public String convertirNumero(@PathVariable Integer numero) {
        Integer numeroComplementario;

        HashMap<Integer, String> romanos =  new HashMap<>();
        romanos.put(1, "I");
        romanos.put(2, "II");
        romanos.put(3, "III");
        romanos.put(4, "IV");
        romanos.put(5, "V");
        romanos.put(9, "IX");
        romanos.put(10, "X");
        romanos.put(50, "L");
        romanos.put(100, "C");
        romanos.put(500, "D");
        romanos.put(1000, "M");


        if (numero > 5  && numero < 9){
            numeroComplementario = numero - 5;
            return  romanos.get(5).concat(romanos.get(numeroComplementario));
        } else if (numero > 10 && numero <= 39) {
            numeroComplementario = Math.round(numero / 10);
            Integer numeroBase =  numero - (numeroComplementario * 10);
            System.out.println(numeroBase);
            return  romanos.get(10).repeat(numeroComplementario).concat(romanos.get(numeroBase));
        } else if (romanos.containsKey(numero)) {
            return romanos.get(numero);
        } else{
            return "No se encontro el numero.";
        }


    }

}
