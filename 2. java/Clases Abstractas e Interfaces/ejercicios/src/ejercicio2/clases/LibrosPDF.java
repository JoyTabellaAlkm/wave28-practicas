package ejercicio2.clases;

import ejercicio2.interfaces.IDocumento;

public class LibrosPDF implements IDocumento {

    private int cantidadPaginas;
    private String nombreAutor;
    private String titulo;
    private String genero;

    @Override
    public void imprimir() {
        System.out.println("Información del libro -> Título: "+this.titulo);
        System.out.println("Autor: "+this.nombreAutor);
        System.out.println("Genero: "+this.genero);
        System.out.println("Páginas: "+this.cantidadPaginas);
    }

    public LibrosPDF(int cantidadPaginas, String nombreAutor, String titulo, String genero) {
        this.cantidadPaginas = cantidadPaginas;
        this.nombreAutor = nombreAutor;
        this.titulo = titulo;
        this.genero = genero;
    }
}
