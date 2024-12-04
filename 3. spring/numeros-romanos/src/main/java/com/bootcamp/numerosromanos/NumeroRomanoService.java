package com.bootcamp.numerosromanos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NumeroRomanoService {
    Map<Integer, String> numerosRomanos;
    List<Integer> numerosDecimales;

    public NumeroRomanoService() {
        this.numerosRomanos =  new HashMap<>();
        this.numerosRomanos.put(1, "I");
        this.numerosRomanos.put(5, "V");
        this.numerosRomanos.put(10, "X");
        this.numerosRomanos.put(50, "L");
        this.numerosRomanos.put(100, "C");
        this.numerosRomanos.put(500, "D");
        this.numerosRomanos.put(1000, "M");

        this.numerosDecimales = new ArrayList<>(List.of(1000, 500, 100, 50, 10, 5 , 1));
    }

    public String convertirDecimalANumeroRomano(int numero) {
        if (numero == 0) {
            return "El numero 0 no existe en la numeración romana!";
        }

        StringBuilder numeroRomanoConvertido = new StringBuilder();
        for (int i = 0; i < numerosDecimales.size(); i++) {
            if(numero == 0) {
                break;
            }
            if (numerosDecimales.get(i) <= numero) {
                numeroRomanoConvertido.append(numerosRomanos.get(numerosDecimales.get(i)));
                numero -= numerosDecimales.get(i);
                i = 0;
            }
        }

        return numeroRomanoConvertido.toString();
    }

}
