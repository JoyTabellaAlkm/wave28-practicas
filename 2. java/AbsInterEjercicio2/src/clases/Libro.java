package clases;

import interfaces.Imprimible;

public class Libro implements Imprimible {
    String titulo;
    String genero;
    String autor;
    int cantPaginas;

    public Libro(String titulo, String genero, String autor, int cantPaginas) {
        this.titulo = titulo;
        this.genero = genero;
        this.autor = autor;
        this.cantPaginas = cantPaginas;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getCantPaginas() {
        return cantPaginas;
    }

    public void setCantPaginas(int cantPaginas) {
        this.cantPaginas = cantPaginas;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "titulo='" + titulo + '\'' +
                ", genero='" + genero + '\'' +
                ", autor='" + autor + '\'' +
                ", cantPaginas=" + cantPaginas +
                '}';
    }

    @Override
    public void imprimirContenido() {
        System.out.println(this);
    }
}
