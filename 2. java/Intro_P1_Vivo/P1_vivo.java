package com.company;
import java.util.Scanner;

public class Main {
    static String[] cities = new String[10];
    static int[][] temperatures = new int[10][2];

    public static void main(String[] args) {
        getCityData();
        showMinMaxTemperatures();
    }

    public static void getCityData() {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 10; i++) {
            System.out.println("Ingrese el nombre de la ciudad:");
            cities[i] = scanner.nextLine();

            System.out.println("Ingrese la temperatura mínima para la ciudad " + cities[i] + ":");
            temperatures[i][0] = scanner.nextInt();
            System.out.println("Ingrese la temperatura máxima para la ciudad " + cities[i] + ":");
            temperatures[i][1] = scanner.nextInt();

            scanner.nextLine();
        }
    }

    // Método para encontrar la ciudad con la temperatura mínima y máxima
    public static void showMinMaxTemperatures() {
        int minTemp = Integer.MAX_VALUE;
        int maxTemp = Integer.MIN_VALUE;
        String minTempCity = "";
        String maxTempCity = "";

        for (int i = 0; i < temperatures.length; i++) {
            if (temperatures[i][0] < minTemp) {
                minTemp = temperatures[i][0];
                minTempCity = cities[i];
            }
            if (temperatures[i][1] > maxTemp) {
                maxTemp = temperatures[i][1];
                maxTempCity = cities[i];
            }
        }

        // Mostrar los resultados
        printResults(minTemp, maxTemp, minTempCity, maxTempCity);
    }

    // Método para imprimir los resultados
    public static void printResults(int minTemp, int maxTemp, String minTempCity, String maxTempCity) {
        System.out.println("La temperatura mínima fue " + minTemp + " en la ciudad " + minTempCity);
        System.out.println("La temperatura máxima fue " + maxTemp + " en la ciudad " + maxTempCity);
    }
}