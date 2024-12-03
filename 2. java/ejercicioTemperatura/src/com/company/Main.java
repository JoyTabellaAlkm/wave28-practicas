package com.company;

public class Main {

    public static void main(String[] args) {
        // write your code here
        String vector_ciudades[] = new String[10];
        vector_ciudades[0] = "Londres";
        vector_ciudades[1] = "Madrid";
        vector_ciudades[2] = "Nueva York";
        vector_ciudades[3] = "Buenos Aires";
        vector_ciudades[4] = "Asunción";
        vector_ciudades[5] = "São Paulo";
        vector_ciudades[6] = "Lima";
        vector_ciudades[7] = "Santiago de Chile";
        vector_ciudades[8] = "Lisboa";
        vector_ciudades[9] = "Tokio";
        int vector_temperatura_min[] ={-2,-3,-8,4,6,5,0,-7,-1,-10};
        int vector_temperatura_max[] = {33,32,27,37,42,43,39,26,31,35};
        String ciudad_max, ciudad_min;
        ciudad_max = ciudad_min = "";
        int temp_min, temp_max;
        temp_max = Integer.MIN_VALUE;
        temp_min = Integer.MAX_VALUE;
        System.out.println(temp_min);

        for (int cont = 0; cont < vector_ciudades.length; ++cont){
            if (temp_min > vector_temperatura_min[cont]){
                temp_min = vector_temperatura_min[cont];
                ciudad_min = vector_ciudades[cont];
            }
            if (temp_max < vector_temperatura_max[cont]){
                temp_max = vector_temperatura_max[cont];
                ciudad_max = vector_ciudades[cont];
            }
        }
        System.out.println("Ciudad con temperatura minima: " + ciudad_min + " Temperatura minima: " + temp_min);
        System.out.println("Ciudad con temperatura maxima: " + ciudad_max + " Temperatura maxima: " + temp_max);

    }
}
