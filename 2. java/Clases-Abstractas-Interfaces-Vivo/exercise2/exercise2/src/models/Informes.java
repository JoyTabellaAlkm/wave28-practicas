package models;

import interfaces.IImprimible;

public class Informes implements IImprimible {

    String text;
    int cantPaginas;
    Persona autor;
    Persona revisor;

    public Informes(String text, int cantPaginas, Persona autor, Persona revisor) {
        this.text = text;
        this.cantPaginas = cantPaginas;
        this.autor = autor;
        this.revisor = revisor;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getCantPaginas() {
        return cantPaginas;
    }

    public void setCantPaginas(int cantPaginas) {
        this.cantPaginas = cantPaginas;
    }

    public Persona getAutor() {
        return autor;
    }

    public void setAutor(Persona autor) {
        this.autor = autor;
    }

    public Persona getRevisor() {
        return revisor;
    }

    public void setRevisor(Persona revisor) {
        this.revisor = revisor;
    }

    @Override
    public String toString() {
        return "Informes{" +
                "longitud='" + text + '\'' +
                ", cantPaginas=" + cantPaginas +
                ", autor=" + autor +
                ", revisor=" + revisor +
                '}';
    }

    @Override
    public void imprimir() {
        System.out.println(this);
    }
}
