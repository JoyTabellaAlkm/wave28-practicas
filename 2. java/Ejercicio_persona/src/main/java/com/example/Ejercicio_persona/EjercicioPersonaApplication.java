package com.example.Ejercicio_persona;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EjercicioPersonaApplication {

	public static void main(String[] args) {
		Persona persona1 = new Persona();
		Persona persona2 = new Persona("Maria",21,"33444666");
		Persona persona3 = new Persona("Pablo", 34, "33444777",62.5,1.72);

		//Persona persona4 = new Persona("Juan", 45);

		System.out.println(persona3);
		//System.out.println(persona3.toString());

		persona3.calcularIMC();
		persona3.esMayorDeEdad();







	}

}
