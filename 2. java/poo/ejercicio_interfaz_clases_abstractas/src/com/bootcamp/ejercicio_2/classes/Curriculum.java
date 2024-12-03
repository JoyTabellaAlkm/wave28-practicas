package com.bootcamp.ejercicio_2.classes;

import com.bootcamp.ejercicio_2.interfaces.IImprimible;

public class Curriculum extends Documento{
    public Curriculum(String tipo) {
        super(tipo);
    }

    @Override
    public void imprimir() {
        System.out.println("Imprimiendo Curriculum");
    }
}
