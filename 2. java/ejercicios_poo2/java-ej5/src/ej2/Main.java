package ej2;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Curriculum c = new Curriculum("Tomas Peiretti", List.of("Java", "Trabajo en equipo"));
        Informe f = new Informe("Este es el texto del informe", 1, "Juan John", "Robert P.");
        LibroPDF pdf = new LibroPDF(100, "Don Juan", "Como desarrollar en Java", "Educacion");

        imprimirDocumento(c);
        imprimirDocumento(f);
        imprimirDocumento(pdf);
    }

    public static void imprimirDocumento(Documentable d) {
        d.imprimir();
    }
}
