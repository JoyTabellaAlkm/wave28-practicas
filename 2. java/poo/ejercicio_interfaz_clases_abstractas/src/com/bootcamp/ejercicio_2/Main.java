package com.bootcamp.ejercicio_2;

import com.bootcamp.ejercicio_2.classes.Curriculum;
import com.bootcamp.ejercicio_2.classes.Documento;
import com.bootcamp.ejercicio_2.classes.Informe;
import com.bootcamp.ejercicio_2.classes.Pdf;

public class Main {
    public static void main(String[] args) {

        Pdf libro = new Pdf("Libros en PDF");
        Informe informe = new Informe("Informes");
        Curriculum curriculum = new Curriculum("Curriculums");

        imprimir(libro);
        imprimir(informe);
        imprimir(curriculum);

    }

    public static void imprimir(Documento doc) {
        doc.imprimir();
    }
}