package org.example;

public class LibrosEnPDF extends Documento{
    private String titulo;
    private String autor;
    private int cantPaginas;
    private String genero;


    public LibrosEnPDF(String titulo, String autor, int cantPaginas, String genero) {
        this.titulo = titulo;
        this.autor = autor;
        this.cantPaginas = cantPaginas;
        this.genero = genero;
    }

    @Override
    public String toString() {
        return "LibrosEnPDF{" +
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", cantPaginas=" + cantPaginas +
                ", genero='" + genero + '\'' +
                "} ";
    }
}
