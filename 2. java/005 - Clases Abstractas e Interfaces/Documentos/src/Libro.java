import Interfaces.IDocumento;

import java.util.List;

public class Libro implements IDocumento {
    private String autor;
    private int noPaginas;
    private String titulo;
    private String genero;


    public Libro(String autor, int noPaginas, String titulo, String genero) {
        this.autor = autor;
        this.noPaginas = noPaginas;
        this.titulo = titulo;
        this.genero = genero;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getNoPaginas() {
        return noPaginas;
    }

    public void setNoPaginas(int noPaginas) {
        this.noPaginas = noPaginas;
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

    @Override
    public void imprimir() {
        System.out.println("Libro: ");
        System.out.println("Autor: "+autor);
        System.out.println("Titulo: "+titulo);
        System.out.println("Genero: "+genero);
        System.out.println("No Paginas: "+noPaginas);
        }

}
