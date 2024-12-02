package com.company;

public class Informes implements IDocumentos {

    private String autor;
    private String cantidadPaginas;
    private String revisor;

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getCantidadPaginas() {
        return cantidadPaginas;
    }

    public void setCantidadPaginas(String cantidadPaginas) {
        this.cantidadPaginas = cantidadPaginas;
    }

    public String getRevisor() {
        return revisor;
    }

    public void setRevisor(String revisor) {
        this.revisor = revisor;
    }

    @Override
    public void imprimir(){
        System.out.println("Informes{" +
                "autor='" + autor + '\'' +
                ", cantidadPaginas='" + cantidadPaginas + '\'' +
                ", revisor='" + revisor + '\'' +
                '}');
    }

}
