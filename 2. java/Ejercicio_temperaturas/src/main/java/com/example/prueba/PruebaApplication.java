package com.example.prueba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PruebaApplication {

	public static void main(String[] args) {

		SpringApplication.run(PruebaApplication.class, args);

		String[] ciudades = {"Londres", "Madrid", "Nueva York", "Buenos Aires","Asuncion", "São Paulo", "Lima", "Santiago de Chile", "Lisboa", "Tokyo"};
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
		int minTemp = temperaturas[0][0];
		int maxTemp = temperaturas[0][1];
		String ciudadMinTemp = ciudades[0];
		String ciudadMaxTemp = ciudades[0];

		for (int i=0 ; i<temperaturas.length ; i++) {

			int tempMinActual = temperaturas[i][0];
			int tempMaxActual = temperaturas[i][1];

			if (tempMinActual < minTemp){
				minTemp = tempMinActual;
				ciudadMinTemp = ciudades[i];
			}

			if (tempMaxActual > maxTemp){
				maxTemp = tempMaxActual;
				ciudadMaxTemp = ciudades[i];
			}

		}
		System.out.println("La ciudad con mayor temperatura es " + ciudadMaxTemp + " y fue de " + maxTemp);
		System.out.println("La ciudad con menor temperatura es " + ciudadMinTemp + " y fue de " + minTemp);

	}

}
