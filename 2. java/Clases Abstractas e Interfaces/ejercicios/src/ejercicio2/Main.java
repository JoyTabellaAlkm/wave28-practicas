package ejercicio2;

import ejercicio2.clases.Curriculum;
import ejercicio2.clases.Informes;
import ejercicio2.clases.LibrosPDF;
import ejercicio2.interfaces.IDocumento;

import java.util.Arrays;

public class Main {
    public static void main(String[] args){
        Curriculum curriculum = new Curriculum("Nico","1234321", "nico@correo.co", Arrays.asList("Diseño", "Desarrollo"));
        LibrosPDF libroPDF = new LibrosPDF(354, "C.S. Lewis", "Narnia", "Fantasía");
        Informes informe = new Informes(4, "Ernesto", "Manuel", "Ejemplo informe");

        IDocumento.imprimirDocumento(curriculum);
        IDocumento.imprimirDocumento(libroPDF);
        IDocumento.imprimirDocumento(informe);
    }
}
