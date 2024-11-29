import java.lang.*;
import java.util.Scanner;

class Temperatura {
    public static void main(String[] args) {

        String[] cities = {
                "Londres",
                "Madrid",
                "Nueva York",
                "Buenos Aires",
                "Asunción",
                "São Paulo",
                "Lima",
                "Santiago de Chile",
                "Lisboa",
                "Tokio"
        };

        int[][] temperature = {
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

        int menor_temperatura = 0;
        String name_menor_temperatura = "";

        int mayor_temperatura = 0;
        String name_mayor_temperatura = "";


        for (int row = 0; row < temperature.length; row++) {
            for (int column = 0; column < temperature[row].length; column++) {
                if (temperature[row][column] < menor_temperatura) {
                    name_menor_temperatura = cities[row];
                    menor_temperatura = temperature[row][column];
                }

                if (temperature[row][column] > mayor_temperatura) {
                    name_mayor_temperatura = cities[row];
                    mayor_temperatura = temperature[row][column];
                }
            }
        }

        System.out.println("La ciudad con menor temperatura es " + name_menor_temperatura + " con " + menor_temperatura);

        System.out.println("La ciudad con mayor temperatura es " + name_mayor_temperatura + " con " + mayor_temperatura);

    }
}

