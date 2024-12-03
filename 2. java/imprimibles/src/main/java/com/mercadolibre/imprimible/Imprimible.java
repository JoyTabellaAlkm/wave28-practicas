package com.mercadolibre.imprimible;

public interface Imprimible {

    public void imprimir();

    public static void imprimirDocumento(Imprimible imprimible) {
        imprimible.imprimir();
    }

}
