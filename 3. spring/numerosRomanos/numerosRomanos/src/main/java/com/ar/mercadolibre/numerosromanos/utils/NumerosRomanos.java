package com.ar.mercadolibre.numerosromanos.utils;

import java.util.TreeMap;


public class NumerosRomanos {

    public static TreeMap<Integer, String> numerosRomanos = new TreeMap<>() {{
            put(1, "I");
            put(4, "IV");
            put(5, "V");
            put(9, "IX");
            put(10, "X");
            put(40, "XL");
            put(50, "L");
            put(90, "XC");
            put(100, "C");
            put(400, "CD");
            put(500, "D");
            put(900, "DM");
            put(1000, "M");
    }};

    public static String devolverRomano(Integer numeroDecimal) {
        System.out.println(numeroDecimal);
        Integer menorOIgualADecimal = numerosRomanos.floorKey(numeroDecimal);

        if (numeroDecimal <= 0 || numeroDecimal > 3999) {
            return "Numero invalido";
        }

        if(numeroDecimal.equals(menorOIgualADecimal)) {
            return numerosRomanos.get(numeroDecimal);
        }

        return numerosRomanos.get(menorOIgualADecimal) + devolverRomano(numeroDecimal - menorOIgualADecimal);
    }
}
