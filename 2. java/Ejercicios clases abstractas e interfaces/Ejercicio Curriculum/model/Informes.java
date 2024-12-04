package org.example.model;

import org.example.IImprimible;

public class Informes implements IImprimible {

    private Texto texto;

    public Informes(Texto texto) {
        this.texto = texto;
    }

    public Texto getTexto() {
        return texto;
    }

    public void setTexto(Texto texto) {
        this.texto = texto;
    }

    @Override
    public String toString() {
        return "Informes{" +
                "texto=" + texto +
                '}';
    }

    @Override
    public String imprimir() {
        return toString();
    }
}
