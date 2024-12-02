package com.mercadolibre;

import java.util.Arrays;

import com.mercadolibre.documentos.Curriculum;
import com.mercadolibre.documentos.Informe;
import com.mercadolibre.documentos.LibroPdf;
import com.mercadolibre.imprimible.Imprimible;

public class Main {
    public static void main(String[] args) {
        Imprimible.imprimirDocumentos(new Curriculum("Andrés Baquero", "3112401388", "Calle 1234", "Resumen...",
                Arrays.asList("Java", "Spring", "Angular", "React")));
        Imprimible.imprimirDocumentos(new Informe("Informe de biología", 10, "Andrés Baquero", "Joy Tabella"));
        Imprimible.imprimirDocumentos(new LibroPdf(20, "Andrés Baquero", "Aprendiendo Java", "Programación"));
    }
}
