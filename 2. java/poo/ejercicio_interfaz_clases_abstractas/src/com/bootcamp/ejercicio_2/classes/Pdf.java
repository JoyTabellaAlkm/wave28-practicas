package com.bootcamp.ejercicio_2.classes;

import com.bootcamp.ejercicio_2.interfaces.IImprimible;

public class Pdf extends Documento{
    public Pdf(String tipo) {
        super(tipo);
    }

    @Override
    public void imprimir() {
        System.out.println("Imprimiendo Libro en PDF");
    }
}
