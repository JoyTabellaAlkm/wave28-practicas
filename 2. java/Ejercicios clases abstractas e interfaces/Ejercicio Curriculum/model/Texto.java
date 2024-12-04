package org.example.model;

public class Texto {

    private int longitud;
    private int cantPag;
    private String autor;
    private String revisor;

    public Texto(int longitud, int cantPag, String autor, String revisor) {
        this.longitud = longitud;
        this.cantPag = cantPag;
        this.autor = autor;
        this.revisor = revisor;
    }

    public int getLongitud() {
        return longitud;
    }

    public void setLongitud(int longitud) {
        this.longitud = longitud;
    }

    public int getCantPag() {
        return cantPag;
    }

    public void setCantPag(int cantPag) {
        this.cantPag = cantPag;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getRevisor() {
        return revisor;
    }

    public void setRevisor(String revisor) {
        this.revisor = revisor;
    }
}
