package com.mercadolibre;

import java.util.Arrays;
import java.util.List;

import com.mercadolibre.documentos.Curriculum;
import com.mercadolibre.documentos.Informe;
import com.mercadolibre.documentos.LibroPdf;
import com.mercadolibre.documentos.Documento;
import com.mercadolibre.imprimible.Imprimible;

public class Main {
    public static void main(String[] args) {
        List<String> habilidades = Arrays.asList("Java", "Spring", "Angular", "React");
        Documento curriculum = new Curriculum("Andrés Baquero", "3112401388", "Calle 1234", "Resumen...", habilidades);

        Documento informe = new Informe("Informe de biología", 10, "Andrés Baquero", "Joy Tabella");
        Documento libroPdf = new LibroPdf(20, "Andrés Baquero", "Aprendiendo Java", "Programación");

        Imprimible.imprimirDocumento(curriculum);
        Imprimible.imprimirDocumento(informe);
        Imprimible.imprimirDocumento(libroPdf);
    }
}
