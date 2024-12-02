package com.example.Ejercicios_claseAbstractaEInterfaces.Ejercicio_Impresora.Documentos;

public class Informe {
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

    @Override
    public String toString() {
        return "Informe{" + '\n' +
                "texto='" + texto + '\n' +
                ", cantPaginas=" + cantPaginas + '\n' +
                ", autor='" + autor + '\n' +
                ", revisor='" + revisor + '\n' +
                '}';
    }
}
