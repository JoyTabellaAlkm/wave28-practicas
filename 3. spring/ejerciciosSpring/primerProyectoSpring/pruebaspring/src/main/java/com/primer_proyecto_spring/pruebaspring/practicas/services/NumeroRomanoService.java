package com.primer_proyecto_spring.pruebaspring.practicas.services;

import java.util.HashMap;
import java.util.Map;

public interface NumeroRomanoService {

    Map<Integer, String> mapaNumeros = new HashMap<Integer, String>() {{
        put(1, "I");
        put(2, "II");
        put(3, "III");
        put(4, "IV");
        put(5, "V");
        put(6, "VI");
        put(7, "VII");
        put(8, "VIII");
        put(9, "IX");
        put(10, "X");
    }};
    public String convertirNumero(int numero);

}
