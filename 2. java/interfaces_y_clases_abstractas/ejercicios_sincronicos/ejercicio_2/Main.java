package interfaces_y_clases_abstractas.ejercicios_sincronicos.ejercicio_2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Persona persona1 = new Persona("Caraballo", "11222333", 21, "Lucas");
        Persona persona2 = new Persona("Simonetti", "57659385", 39, "Martin");

        List<String> habilidades = Stream.of("Java", "TS", "Lindo").toList();

        Informe informe = new Informe(persona1, 15, persona2, "Lorem ipsum");
        Curriculum cv = new Curriculum(habilidades, persona1);
        LibroPDF libroPDF = new LibroPDF(persona1, 200, "Aprendiendo Java", "Educación");

        System.out.println("=== IMPRESIÓN DE DOCUMENTOS ===");
        informe.imprimir();
        cv.imprimir();
        libroPDF.imprimir();
    }
}
