package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        String ciudades[] = {"Londres",
                "Madrid",
                "Nueva York",
                "Buenos Aires",
                "Asunción",
                "Lima",
                "Sao Paulo",
                "Santiago de Chile",
                "Lisboa",
                "Tokio"};
        int temperatura[][] ={
                {-2, 33},
                {-3,32},
                {-8,27},
                {4,37},
                {6,42},
                {5,43},
                {0,39},
                {-7,26},
                {-1,31},
                {-10,35}
        };
        int tempMenor = temperatura[0][0];
        int tempMayor = temperatura[0][1];
        int indiceMayor = 0;
        int indiceMenor = 0;
        for(int f = 0; f < 10; f++){
                if(temperatura[f][0]<tempMenor){
                    tempMenor = temperatura[f][0];
                    indiceMenor = f;
                }
                if(temperatura[f][1]>tempMayor){
                    tempMayor = temperatura[f][1];
                    indiceMayor = f;
                }
        }
        System.out.println("La ciudad con menor temperatura es "+ciudades[indiceMenor]+" con "+ tempMenor +" Grados");
        System.out.println("La ciudad con mayor temperatura es "+ciudades[indiceMayor]+ " con "+tempMayor+ " Grados");
    }
}
