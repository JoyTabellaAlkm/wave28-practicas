package com.bootcamp.ejercicio_2.classes;

import com.bootcamp.ejercicio_2.interfaces.IImprimible;

public abstract class Documento implements IImprimible {
    private String tipo;

    public Documento(String tipo) {
        this.tipo = tipo;
    }
}
