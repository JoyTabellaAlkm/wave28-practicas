package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
	Libro libro = new Libro(240, "Marco Aurelio", "Meditaciones", "Filosofia");
	libro.imprimible();

	Informe informe = new Informe("Esto es un texto de prueba....", 1, "Desconocido", "Anonimo");
    informe.imprimible();

    ArrayList<String> habilidades = new ArrayList<String>();
    habilidades.add("habildiad1");
    habilidades.add("habilidad2");

    Curriculum curriculum = new Curriculum("Curriculum prueba", habilidades);
    curriculum.imprimible();

    }
}
