import clases.Curriculum;
import clases.Libro;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Curriculum astrid = new Curriculum("Astrid", "Malamud", 33, Arrays.asList("C#", "Trabajo en equipo", "Ingles Avanzado"));
        Libro harryPotter = new Libro(500, "J K Rowling", "Harry Potter", "Infantil");

        astrid.imprimirDocumento(astrid);
        harryPotter.imprimirDocumento(harryPotter);


     }
}