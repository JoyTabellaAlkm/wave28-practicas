package com.company;

public class Main {

    public static void main(String[] args) {
        //cargué manualmente las ciudades en un vector
	    String ciudades[] = new String[10];
	    ciudades[0] = "Londres";
	    ciudades[1] = "Madrid";
        ciudades[2] = "Nueva York";
        ciudades[3] = "Buenos Aires";
        ciudades[4] = "Asunción";
        ciudades[5] = "Sao Pablo";
        ciudades[6] = "Lima";
        ciudades[7] = "Santiago de Chile";
        ciudades[8] = "Lisboa";
        ciudades[9] = "Tokio";

        //cargué manualemnte las temperaturas en una matriz

        int temperaturas[][] = new int[10][2];

        temperaturas[0][0] = -2;
        temperaturas[0][1] = 33;
        temperaturas[1][0] = -3;
        temperaturas[1][1] = 32;
        temperaturas[2][0] = -8;
        temperaturas[2][1] = 27;
        temperaturas[3][0] = 4;
        temperaturas[3][1] = 37;
        temperaturas[4][0] = 6;
        temperaturas[4][1] = 42;
        temperaturas[5][0] = 5;
        temperaturas[5][1] = 43;
        temperaturas[6][0] = 0;
        temperaturas[6][1] = 39;
        temperaturas[7][0] = -7;
        temperaturas[7][1] = 26;
        temperaturas[8][0] = -1;
        temperaturas[8][1] = 31;
        temperaturas[9][0] = -10;
        temperaturas[9][1] = 35;

        int max = temperaturas[0][0];
        int min = temperaturas[0][0];
        String ciudadMinima = ciudades[0];
        String ciudadMaxima = ciudades[0];

        //Recorro la matriz de temperaturas para encontrar la mínima y la máxima
        for(int f = 0; f < 10; f++){
            for(int c = 0; c < 2; c++){
                if(temperaturas[f][c] > max){
                    ciudadMaxima = ciudades[f];
                    max = temperaturas[f][c];
                }
                if(temperaturas[f][c] < min){
                    ciudadMinima = ciudades[f];
                    min = temperaturas[f][c];
                }
            }

        }

        System.out.println("La ciudad con la mayor temperatura fue: " + ciudadMaxima + " con una temperatura de: " + max);
        System.out.println("La ciudad con la menor temperatura fue: " + ciudadMinima + " con una temperatura de: " + min);
    }
}
