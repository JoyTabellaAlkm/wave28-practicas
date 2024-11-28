package com.mercadolibre.temperaturas;

import java.util.Scanner;

public class Temperatura {
    public static void main(String[] args) {
        Scanner consola = new Scanner(System.in);

        System.out.println("Ingresa la cantidad de ciudades:");
        // int citiesNumber;
        // do {
        // citiesNumber = Integer.parseInt(console.nextLine());
        // if (citiesNumber < 1) {
        // System.out.println("Ingresa un número mayor a 0");
        // }
        // } while (citiesNumber < 1);

        int numeroDeCiudades = Integer.parseInt(consola.nextLine());
        while (numeroDeCiudades <= 0) {
            System.out.println("numero invalido, por favor ingrese otro valor:");
            numeroDeCiudades = Integer.parseInt(consola.nextLine());
        }

        String ciudades[] = new String[numeroDeCiudades];
        int temperaturas[][] = new int[numeroDeCiudades][2];

        for (int i = 0; i < ciudades.length; i++) {
            System.out.println("Ingresa la ciudad");
            String ciudad = consola.nextLine();
            ciudades[i] = ciudad;

            System.out.println("Ingresa la temperatura minima:");
            int temperatura = Integer.parseInt(consola.nextLine());
            temperaturas[i][0] = temperatura;

            System.out.println("Ingresa la temperatura maxima:");
            temperatura = Integer.parseInt(consola.nextLine());
            temperaturas[i][1] = temperatura;

            System.out.println("--------------------------------------------");
        }

        int minima = 0;
        int maxima = 0;
        for (int i = 0; i < numeroDeCiudades; i++) {
            if (temperaturas[i][0] < temperaturas[minima][0]) {
                minima = i;
            }
            if (temperaturas[i][1] > temperaturas[maxima][1]) {
                maxima = i;
            }
        }

        System.out.println("La menor temperatura mínima la tuvo " + ciudades[minima]
                + " con " + temperaturas[minima][0] + " °C.");
        System.out.println("La mayor temperatura máxima la tuvo " + ciudades[maxima]
                + " con " + temperaturas[maxima][1] + " °C.");

        consola.close();
    }
}
