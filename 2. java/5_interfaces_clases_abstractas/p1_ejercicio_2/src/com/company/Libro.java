package com.company;

public class Libro implements IImprimir<Libro> {
    int cantidadPaginas;
    String nombreAutor;
    String titulo;
    String genero;

    public Libro(int cantidadPaginas, String nombreAutor, String titulo, String genero) {
        this.cantidadPaginas = cantidadPaginas;
        this.nombreAutor = nombreAutor;
        this.titulo = titulo;
        this.genero = genero;
    }

    @Override
    public void imprimible(Libro document) {
        System.out.println("Data Libro: Titulo: " + this.titulo + ", autor: " + this.nombreAutor + ", genero: " + this.genero + ", cantidad de paginas: " + this.cantidadPaginas);
    }
}
