package clases;

import interfaces.Documento;

public class Libro implements Documento {
    private int cantPaginas;
    private String nombreAutor;
    private String titulo;
    private String genero;

    public Libro(int cantPaginas, String nombreAutor, String titulo, String genero){
        this.cantPaginas = cantPaginas;
        this.nombreAutor = nombreAutor;
        this.titulo = titulo;
        this.genero = genero;
    }

    public void setNombreAutor(String nombreAutor) {
        this.nombreAutor = nombreAutor;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setCantPaginas(int cantPaginas) {
        this.cantPaginas = cantPaginas;
    }

    public String getNombreAutor() {
        return this.nombreAutor;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public String getGenero() {
        return this.genero;
    }

    public int getCantPaginas() {
        return this.cantPaginas;
    }

    @Override
    public String toString() {
        String resultado = "\r\nInformacion de: " + this.titulo;
        resultado += "\r\nCantidad de paginas: " + this.cantPaginas;
        resultado += "\r\nAutor: " + this.nombreAutor;
        resultado += "\r\nGenero: " + this.genero;
        return resultado;
    }
}
