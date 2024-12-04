package com.numerosromanos.api.services;

import com.numerosromanos.api.dto.Response;

public class RomanNumberService {
    public static Response numberToRoman(int number) {
        if (number <= 0 || number > 3999) {
            return new Response("El número debe estar entre 1 y 3999");
        }

        int[] valores = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] simbolos = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder resultado = new StringBuilder();

        for (int i = 0; i < valores.length; i++) {
            while (number >= valores[i]) {
                resultado.append(simbolos[i]);
                number -= valores[i];
            }
        }

        return new Response(resultado.toString());
    }
}
