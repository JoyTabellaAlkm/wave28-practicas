package practica_temperaturas_globales.src.meli.practica;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        double matrizTemperaturas[][] = new double[10][2];
        double tempMinima, tempMaxima;
        String nombreCiudadMinima, nombreCiudadMaxima;

        String ciudades[] = {"Londres", "Madrid", "Nueva York", "Buenos Aires", "Asunción", "São Paulo", "Lima", "Santiago de Chile", "Lisboa", "Tokio"};

        Scanner teclado = new Scanner(System.in);

        System.out.println("Bienvenido a la aplicación de temperaturas globales");
        System.out.println("---------------------------------------------------------");
        System.out.println("Por favor carga los datos de temperatura de las ciudades de la tabla");
        System.out.println("---------------------------------------------------------");

        for (int indiceCiudades = 0; indiceCiudades < ciudades.length; indiceCiudades++) {
            System.out.print("Ingrese la temperatura mínima para la ciudad de " + ciudades[indiceCiudades] + ": ");
            matrizTemperaturas[indiceCiudades][0] = teclado.nextDouble();

            System.out.print("Ingrese la temperatura máxima para la ciudad de " + ciudades[indiceCiudades] + ": ");
            matrizTemperaturas[indiceCiudades][1] = teclado.nextDouble();

            System.out.println("---------------------------------------------------------");
        }

        teclado.close();

        tempMinima = matrizTemperaturas[0][0];
        nombreCiudadMinima = ciudades[0];
        tempMaxima = matrizTemperaturas[0][1];
        nombreCiudadMaxima = ciudades[0];

        for (int indiceCiudades = 0; indiceCiudades < ciudades.length; indiceCiudades++) {
            if (matrizTemperaturas[indiceCiudades][0] < tempMinima) {
                tempMinima = matrizTemperaturas[indiceCiudades][0];
                nombreCiudadMinima = ciudades[indiceCiudades];
            }
            if (matrizTemperaturas[indiceCiudades][1] > tempMaxima) {
                tempMaxima = matrizTemperaturas[indiceCiudades][1];
                nombreCiudadMaxima = ciudades[indiceCiudades];
            }
        }

        System.out.println("Resultados");
        System.out.println("La temperatura mínima es de: " + tempMinima + " grados celsius en la ciudad de: " + nombreCiudadMinima);
        System.out.println("---------");
        System.out.println("La temperatura máxima es de: " + tempMaxima + " grados celsius en la ciudad de: " + nombreCiudadMaxima);
    }
}