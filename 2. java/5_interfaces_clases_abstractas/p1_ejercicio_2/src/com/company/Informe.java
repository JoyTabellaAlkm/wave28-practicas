package com.company;

public class Informe implements IImprimir<Informe>{

    String texto;
    int cantidadPaginas;
    String autor;
    String revisor;

    public Informe(String texto, int cantidadPaginas, String autor, String revisor) {
        this.texto = texto;
        this.cantidadPaginas = cantidadPaginas;
        this.autor = autor;
        this.revisor = revisor;
    }

    @Override
    public void imprimible(Informe document) {
        System.out.println("Data Informe: Author: " + this.autor + ", revisor: " + this.revisor + ", paginas: " + this.cantidadPaginas + ", texto: " + this.texto);
    }
}
