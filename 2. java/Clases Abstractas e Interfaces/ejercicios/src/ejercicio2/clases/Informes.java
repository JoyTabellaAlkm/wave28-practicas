package ejercicio2.clases;

import ejercicio2.interfaces.IDocumento;

public class Informes implements IDocumento {

    private int cantidadPaginas;
    private String autor, revisor, texto;

    @Override
    public void imprimir() {
        System.out.println("Informe -> Autor: " + this.autor);
        System.out.println("Revisor: " + this.revisor);
        System.out.println("Páginas: " + this.cantidadPaginas);
        System.out.println("Texto del informe: " + this.texto);
    }

    public Informes(int cantidadPaginas, String autor, String revisor, String texto) {
        this.cantidadPaginas = cantidadPaginas;
        this.autor = autor;
        this.revisor = revisor;
        this.texto = texto;
    }
}
