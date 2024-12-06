package com.primer_proyecto_spring.pruebaspring.practicas.services;

public class InumeroRomanoServiceImpl implements NumeroRomanoService{

    // Definimos un mapa de valores romanos y sus correspondientes símbolos
    private static final int[] valores = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    private static final String[] simbolos = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    @Override
    public String convertirNumero(int numero) {
        int numeroInicial = numero;

        if (numero < 1 || numero > 1000) {
            return "Número fuera de rango. Debe ser entre 1 y 1000.";
        }

        StringBuilder resultado = new StringBuilder();

        for (int i = 0; i < valores.length; i++) {
            // Mientras el número sea mayor o igual al valor actual, concatenamos su símbolo
            while (numero >= valores[i]) {
                resultado.append(simbolos[i]);
                numero -= valores[i]; // Restamos el valor correspondiente
            }
        }

        return "El número ingresado: "+ numeroInicial +" en romano es: " + resultado.toString();
    }
}
