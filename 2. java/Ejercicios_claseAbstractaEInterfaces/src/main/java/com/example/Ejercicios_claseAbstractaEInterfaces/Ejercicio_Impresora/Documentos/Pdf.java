package com.example.Ejercicios_claseAbstractaEInterfaces.Ejercicio_Impresora.Documentos;

public class Pdf {

    private String genero;
    private int cantPaginas;
    private String autor;
    private String titulo;

    public Pdf(String genero, int cantPaginas, String autor, String titulo) {
        this.genero = genero;
        this.cantPaginas = cantPaginas;
        this.autor = autor;
        this.titulo = titulo;
    }

    @Override
    public String toString() {
        return "Pdf{" + '\n' +
                "genero='" + genero + '\n' +
                ", cantPaginas=" + cantPaginas + '\n' +
                ", autor='" + autor + '\n' +
                ", titulo='" + titulo + '\n' +
                '}';
    }
}
