package com.example.numerosromanos;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/romano")
public class controladorNumRomano {

    @GetMapping("/decimal")
    public String convertirDecimalARomano(@RequestParam int num){

        if (num < 1 || num > 3999){
            return "No ingresa dentro del rango que trabaja nuestra API. " +
                    "El rango es entre 1 y 3999.";
        }

        StringBuilder resultadoNumeroRomando = new StringBuilder();

        String milesimas[] = {"", "M", "MM", "MMM"};
        String centesimas[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String decimos[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String unidades[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

        resultadoNumeroRomando.append(milesimas[num /1000]);
        resultadoNumeroRomando.append(centesimas[(num %1000)/100]);
        resultadoNumeroRomando.append(decimos[(num %100)/10]);
        resultadoNumeroRomando.append(unidades[num %10]);


        return "El resultado del numero " + num + " decimal en romano es "
                + resultadoNumeroRomando;
    }
}
