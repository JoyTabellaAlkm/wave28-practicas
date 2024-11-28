package com.company;

public class Main {

    public static void main(String[] args) {
        // Vector de ciudades
        String[] ciudades = {
                "Londres", "Madrid", "Nueva York", "Buenos Aires",
                "Asunción", "São Paulo", "Lima", "Santiago de Chile",
                "Lisboa", "Tokio"
        };

        // Matriz de temperaturas (mínimas y máximas)
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
                {-10, 35}
        };

        int tempMin = Integer.MAX_VALUE;
        int tempMax = Integer.MIN_VALUE;
        int inxTempMin = -1;
        int inxTempMax = -1;

        for (int i = 0; i < ciudades.length; i++) {
            if (temperaturas[i][0] < tempMin) {
                tempMin = temperaturas[i][0];
                inxTempMin = i;
            }

            if (temperaturas[i][1] > tempMax) {
                tempMax = temperaturas[i][1];
                inxTempMax = i;
            }
        }

        System.out.println("La menor temperatura fue de la ciudad: " + ciudades[inxTempMin] + " y fue de: " + tempMin);
        System.out.println("La mayor temperatura fue de la ciudad: " + ciudades[inxTempMax] + " y fue de: " + tempMax);

    }
}
