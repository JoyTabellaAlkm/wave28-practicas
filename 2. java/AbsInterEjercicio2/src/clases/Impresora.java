package clases;

import interfaces.Imprimible;

public class Impresora {
    public static void imprimir(Imprimible imprimible) {
        imprimible.imprimirContenido();
    }
}
