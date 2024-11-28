package com.mercadolibre.temperaturas;

public class Main {
    public static void main(String[] args) {
        String[] ciudades = {"Londres", "Madrid", "Nueva York", "Buenos Aires", "Asunción", "Sao Paulo", "Lima", "Santiago de Chile", "Lisboa", "Tokio"};
        int[][] temperaturas = {
            {-2, 33},
            {-3, 32},
            {-8, 27},
            {4, 37},
            {6, 42},
            {5, 43},
            {0, 39},
            {-7, 26},
            {-1, 31},
            {-10, 35},
        };

        int minimo = 0, maximo = 0;
        for (int i = 0; i < ciudades.length; i++) {
            if (temperaturas[i][0] < temperaturas[minimo][0]) {
                minimo = i;
            }
            if (temperaturas[i][1] > temperaturas[maximo][1]) {
                maximo = i;
            }
        }

        System.out.println("Ciudad con la temperatura mínima: " + ciudades[minimo] + " - Su temperatura mínima es: " + temperaturas[minimo][0]);
        System.out.println("Ciudad con la temperatura máxima: " + ciudades[maximo] + " - Su temperatura máxima es: " + temperaturas[maximo][1]);
    }
}