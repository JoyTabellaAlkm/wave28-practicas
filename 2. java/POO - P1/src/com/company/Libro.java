package com.company;

public class Libro {
    String titulo;
    String autor;
    int ejemplares;

    public Libro(String titulo, String autor, int ejemplares) {
        this.titulo = titulo;
        this.autor = autor;
        this.ejemplares = ejemplares;
    }

    public int cantidadEjemplares(){
        return ejemplares;
    }

    public String mostrarLibro(){
        return "Titulo: " + titulo + " Autor: " + autor + "Ejemplares: " + ejemplares;
    }
}
