package com.numerosRomanos.numerosRomanos.services;

import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class NumerosRomanosService {
    private static final Map<Integer, String> numerosRomanos = new LinkedHashMap<>();

    static {
        numerosRomanos.put(1000, "M");
        numerosRomanos.put(900, "CM");
        numerosRomanos.put(500, "D");
        numerosRomanos.put(400, "CD");
        numerosRomanos.put(100, "C");
        numerosRomanos.put(90, "XC");
        numerosRomanos.put(50, "L");
        numerosRomanos.put(40, "XL");
        numerosRomanos.put(10, "X");
        numerosRomanos.put(9, "IX");
        numerosRomanos.put(5, "V");
        numerosRomanos.put(4, "IV");
        numerosRomanos.put(1, "I");
    }

    public  String  convertirANumeroRomano(int numero){
        StringBuilder nromano = new StringBuilder();
        for(Map.Entry<Integer, String> base : numerosRomanos.entrySet()){
            while (numero >= base.getKey()){
                nromano.append(base.getValue());
                numero -= base.getKey();
            }
        }
        return nromano.toString();
    }

}
