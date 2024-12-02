import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        ArrayList<Imprimible> listaImprimible = new ArrayList<>(List.of(
                new Informe(200,"Rodrigo Lopez", "Mucho textorandom",
                        "Juan Jorge"),
                new LibroPDF(205, "Autor PDF", "Titulo PDF", "Suspenso"),
                new Curriculum(new Persona("Pepe", 20), new ArrayList<>(List.of("pdf", "excel", "word")))
        ));

        listaImprimible.forEach(Imprimible::imprimir);
    }
}
