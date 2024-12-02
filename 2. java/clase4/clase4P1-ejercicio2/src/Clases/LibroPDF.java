package Clases;

public class LibroPDF extends Documento {
    private String genero;
    private int cantPaginas;
    private String autor;
    private String titulo;

    public String getGenero() {
        return genero;
    }

    public int getCantPaginas() {
        return cantPaginas;
    }

    public String getAutor() {
        return autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setCantPaginas(int cantPaginas) {
        this.cantPaginas = cantPaginas;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public LibroPDF(String genero, int cantPaginas, String autor, String titulo) {
        this.genero = genero;
        this.cantPaginas = cantPaginas;
        this.autor = autor;
        this.titulo = titulo;
    }

    @Override
    public void imprimir() {
        System.out.println("Imprimiendo PDF...");
    }
}