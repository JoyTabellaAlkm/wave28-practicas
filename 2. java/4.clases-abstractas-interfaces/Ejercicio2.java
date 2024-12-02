package com.bootcamp;

/*
Se plantea desarrollar un programa que permita mediante una interfaz imprimir diferentes tipos de documentos.
        Entre los tipos de documentos se encuentran:

        Curriculums: incluye a una persona con todos sus atributos más una lista de sus habilidades.
        Libros en PDF: Incluyen atributos como cantidad de páginas, nombre del autor, título y género.
        Informes: Incluyen un texto de n longitud, cantidad de páginas, autor, y revisor.
        Representar un escenario donde se creen cada uno de estos objetos y que, por medio de un método estático
        de una interfaz imprimible, se pueda pasar cualquier tipo de documento y sea impreso el contenido

 */

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        // write your code here
        ArrayList<String> habilidades = new ArrayList<String>();
        habilidades.add("TypeScript");
        habilidades.add("POO");
        habilidades.add("Java");
        com.bootcamp.Curriculum cv = new com.bootcamp.Curriculum("Gonzalez Fermin", "Software Developer",
                "123456789", habilidades);

        com.bootcamp.LibroPdf libro = new com.bootcamp.LibroPdf("Diarios de Bicicleta", "David Byrne", 432, "Viajes");

        com.bootcamp.Informe informe = new com.bootcamp.Informe("Este es un informe sobre las tendencias del mercado.", "Fermin", "Informe", "Luisa Fernández");

        com.bootcamp.IImpresionDocumentos.imprimirDocumento(cv);
        com.bootcamp.IImpresionDocumentos.imprimirDocumento(libro);
        com.bootcamp.IImpresionDocumentos.imprimirDocumento(informe);


    }
}


interface IImpresionDocumentos {

    // Método estático para imprimir documentos genericos
    static <T> void imprimirDocumento(T documento) {
        System.out.println(documento.toString());
    }
}

class Curriculum implements com.bootcamp.IImpresionDocumentos {
    String nombreCompleto;
    String puesto;
    String dni;
    ArrayList<String> habilidades = new ArrayList<String>();

    public Curriculum(String nombreCompleto, String puesto, String dni, ArrayList<String> habilidades) {
        this.nombreCompleto = nombreCompleto;
        this.puesto = puesto;
        this.dni = dni;
        this.habilidades = habilidades;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== CURRÍCULUM ===\n")
                .append("Nombre Completo: ").append(nombreCompleto).append("\n")
                .append("Puesto: ").append(puesto).append("\n")
                .append("DNI: ").append(dni).append("\n")
                .append("Habilidades: ").append(String.join(", ", habilidades)).append("\n")
                .append("===================\n");
        return sb.toString();
    }
}

class LibroPdf implements com.bootcamp.IImpresionDocumentos {
    int cantidadPaginas;
    String autor;
    String titulo;
    String genero;

    public LibroPdf(String titulo, String autor, int cantidadPaginas,  String genero) {
        this.titulo = titulo;
        this.autor = autor;
        this.cantidadPaginas = cantidadPaginas;
        this.genero = genero;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== LIBRO PDF ===\n")
                .append("Titulo: ").append(titulo).append("\n")
                .append("Autor: ").append(autor).append("\n")
                .append("Páginas: ").append(cantidadPaginas).append("\n")
                .append("Género: ").append(genero).append("\n")
                .append("===================\n");
        return sb.toString();
    }
}

class Informe implements com.bootcamp.IImpresionDocumentos {
    // texto de n longitud, cantidad de páginas, autor, y revisor.
    String texto;
    String autor;
    String titulo;
    String revisor;

    public Informe(String texto, String autor, String titulo, String revisor) {
        this.texto = texto;
        this.autor = autor;
        this.titulo = titulo;
        this.revisor = revisor;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== INFORME ===\n")
                .append("Titulo: ").append(titulo).append("\n")
                .append("Autor: ").append(autor).append("\n")
                .append("Texto: ").append(texto).append("\n")
                .append("Revisor: ").append(revisor).append("\n")
                .append("===================\n");
        return sb.toString();
    }
}
