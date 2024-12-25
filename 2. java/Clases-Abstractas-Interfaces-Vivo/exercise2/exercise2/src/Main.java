import interfaces.IImprimible;
import models.Curriculum;
import models.Informes;
import models.LibrosEnPDF;
import models.Persona;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<IImprimible> documentos = new ArrayList<>();

        Persona autor = new Persona("Peter", "Parker", "22");
        Persona revisor =  new Persona("Stan", "lee", "60");

        documentos.add(new Curriculum(autor, List.of("super poderes", "tela de arania")));
        documentos.add(new LibrosEnPDF("Spiderman", "Comic", 33, "Stan Lee"));
        documentos.add(new Informes("Muchas aventuras", 50, autor, revisor));

        documentos.forEach(IImprimible::imprimir);
    }
}