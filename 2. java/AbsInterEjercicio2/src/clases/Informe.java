package clases;

import interfaces.Imprimible;

public class Informe implements Imprimible {
    String autor;
    String revisor;
    int cantPaginas;
    String contenido;

    public Informe(String autor, String revisor, int cantPaginas, String contenido) {
        this.autor = autor;
        this.revisor = revisor;
        this.cantPaginas = cantPaginas;
        this.contenido = contenido;
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

    public int getCantPaginas() {
        return cantPaginas;
    }

    public void setCantPaginas(int cantPaginas) {
        this.cantPaginas = cantPaginas;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    @Override
    public String toString() {
        return "Informe{" +
                "autor='" + autor + '\'' +
                ", revisor='" + revisor + '\'' +
                ", cantPaginas='" + cantPaginas + '\'' +
                ", contenido='" + contenido + '\'' +
                '}';
    }

    @Override
    public void imprimirContenido() {
        System.out.println(this);
    }
}
