package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {


        Documento curriculum = new Curriculums("Lisandro","20","1142432223", new ArrayList<>(List.of("java","git")));
        Documento LibroEnPDF = new LibrosEnPDF("Harry Potter", "J.K Rowling", 500, "Fantasia");
        Documento informe = new Informes("Lorem", 300, "Daniel ", "William");




        Imprimible.imprimir(curriculum);

        Imprimible.imprimir(LibroEnPDF);
        Imprimible.imprimir(informe);

    }
}