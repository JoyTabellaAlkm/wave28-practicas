package com.example.Ejercicios_claseAbstractaEInterfaces.Ejercicio_Impresora;

import com.example.Ejercicios_claseAbstractaEInterfaces.Ejercicio_Impresora.Documentos.Curriculum;
import com.example.Ejercicios_claseAbstractaEInterfaces.Ejercicio_Impresora.Documentos.Informe;
import com.example.Ejercicios_claseAbstractaEInterfaces.Ejercicio_Impresora.Documentos.Pdf;

import java.util.ArrayList;
import java.util.List;

public class ImpresoraMain {
    public static void main(String[] args){
        List<String> habilidades = new ArrayList<>();
        habilidades.add("Java");
        habilidades.add("SQL");
        habilidades.add("Agile");
        Curriculum curriculum = new Curriculum("Maria", "Gonzalez",26,habilidades);

        Informe informe = new Informe("Este es un informe", 1, "A. J. S.", "F. A.");
        Pdf pdf = new Pdf("Terror", 120, "S.K.", "T.A.");

        IImprimible.imprimir(curriculum);
        IImprimible.imprimir(informe);
        IImprimible.imprimir(pdf);

    }
}
