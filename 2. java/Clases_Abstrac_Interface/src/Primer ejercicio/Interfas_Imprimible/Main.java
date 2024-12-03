import java.util.ArrayList;
import java.util.List;

public class Main{
    public static void main(String[] args) {
        Persona persona1 = new Persona("Juan perez","2031031");
        Persona persona2 = new Persona("Mario perez","19312031");
        List<String> habilidades = new ArrayList<>(List.of("pintar","cantar","bailar"));

        Curriculums c =  new Curriculums(persona2, habilidades);
        Informe i = new Informe(10, 100, persona1, persona2);
        Libro l = new Libro("pepito", 200, "Pablo nERUDA", "Literatura");

        Imprimible.imprimirDocumento(c);
        Imprimible.imprimirDocumento(i);
        Imprimible.imprimirDocumento(l);

    }
}