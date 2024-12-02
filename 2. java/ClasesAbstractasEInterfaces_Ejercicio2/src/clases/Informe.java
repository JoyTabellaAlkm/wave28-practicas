package clases;

import interfaces.Documento;

public class Informe implements Documento {
    private String texto;
    private int cantPaginas;
    private String autor;
    private String revisor;

    public Informe(String texto, int cantPaginas, String autor, String revisor) {
        this.texto = texto;
        this.cantPaginas = cantPaginas;
        this.autor = autor;
        this.revisor = revisor;
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

    public String getTexto(){
        return this.texto;
    }

    public int getCantPaginas(){
        return this.cantPaginas;
    }

    public String getAutor(){
        return this.autor;
    }

    public String getRevisor(){
        return this.revisor;
    }

    @Override
    public String toString() {
        String resultado = "\r\nInforme ";
        resultado += this.texto;
        resultado += "\r\nAutor: " + this.autor;
        resultado += "\r\nRevisor: " + this.revisor;
        return resultado;
    }

}
