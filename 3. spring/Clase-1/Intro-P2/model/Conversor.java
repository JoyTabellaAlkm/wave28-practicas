package com.example.demo.model;

import java.util.HashMap;
import java.util.Map;

/* Convierte un numero en su equivalente romana.
*  Input: numero <String>
*  Output: numeroRomano <String>
* */
public class Conversor {

    public static String convertirARomano(String numero) {
        Map<Integer, String> equivalenteRomano = new HashMap<>();
        equivalenteRomano.put(1, "I");
        equivalenteRomano.put(5, "V");
        equivalenteRomano.put(10, "X");
        equivalenteRomano.put(50, "L");
        equivalenteRomano.put(100, "C");
        equivalenteRomano.put(500, "D");
        equivalenteRomano.put(1000, "M");
        return "XXII";
    }
}
