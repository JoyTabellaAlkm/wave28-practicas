package com.bootcamp.ejercicio_2.classes;

import com.bootcamp.ejercicio_2.interfaces.IImprimible;

public class Informe extends Documento{
    public Informe(String tipo) {
        super(tipo);
    }

    @Override
    public void imprimir() {
        System.out.println("Imprimiendo Informe");
    }
}
