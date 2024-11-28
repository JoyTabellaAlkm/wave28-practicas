package com.example.EstructurasDinamicas;

import com.example.EstructurasDinamicas.Circuitos.Circuito;
import com.example.EstructurasDinamicas.Inscripciones.Inscripcion;
import com.example.EstructurasDinamicas.Participantes.Participante;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class EstructurasDinamicasApplication {

	public static void main(String[] args) {
		Circuito circuito1 = new Circuito(1, "chico", "2 km.");
		Circuito circuito2 = new Circuito(2, "medio", "2 km.");
		Circuito circuito3 = new Circuito(3, "avanzado", "2 km.");

		Participante part1 = new Participante(22, "33958793","Maria","Ñañez",30,"351-2223334","0000000","AB");
		Participante part2 = new Participante(33, "33958794","Pablo","Sanchez",27,"351-2223334","0000000","AB");
		Participante part3 = new Participante(44, "33958795","Dario","Gomez",46,"351-2223334","0000000","AB");
		Participante part4 = new Participante(55, "33958796","Franco","Colapinto",17,"351-2223334","0000000","AB");

		Inscripcion ins1;
		Inscripcion ins2 = new Inscripcion();
		Inscripcion ins3;
		if (!circuito2.getInscripciones().contains(part1)
				&& !circuito3.getInscripciones().contains(part1)) {
			ins1 = new Inscripcion(145, circuito1, part1);
		}else System.out.println("El participante ya está inscripto en otro circuito");

		if (!circuito2.getInscripciones().contains(part2)
				&& !circuito3.getInscripciones().contains(part2)) {
			ins2 = new Inscripcion(146, circuito1, part2);
		}else System.out.println("El participante ya está inscripto en otro circuito");

		if (!circuito1.getInscripciones().contains(part4)
				&& !circuito2.getInscripciones().contains(part4)) {
			ins3 = new Inscripcion(147, circuito3, part4);
		}else System.out.println("El participante ya está inscripto en otro circuito");

		System.out.println("El circuito 1 cuenta con los siguientes inscriptos: ");
		circuito1.mostrarInscripciones();

		circuito1.eliminarInscripcion(ins2);

		System.out.println("El circuito 1 cuenta con los siguientes inscriptos: ");
		circuito1.mostrarInscripciones();

		System.out.println("El circuito 1 recaudó: " + circuito1.obtenerMontoRecaudadoPorCircuito());

	}

}
