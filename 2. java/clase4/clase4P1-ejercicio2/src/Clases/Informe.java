package Clases;

public class Informe extends Documento{
    private String texto;
    private int cantPaginas;
    private String autor;
    private String revisor;

    public String getTexto() {
        return texto;
    }

    public int getCantPaginas() {
        return cantPaginas;
    }

    public String getAutor() {
        return autor;
    }

    public String getRevisor() {
        return revisor;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public void setCantPaginas(int cantPaginas) {
        this.cantPaginas = cantPaginas;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setRevisor(String revisor) {
        this.revisor = revisor;
    }

    public Informe(String texto, int cantPaginas, String autor, String revisor) {
        this.texto = texto;
        this.cantPaginas = cantPaginas;
        this.autor = autor;
        this.revisor = revisor;
    }

    @Override
    public void imprimir() {
        System.out.println("Imprimiendo informe...");
    }
}