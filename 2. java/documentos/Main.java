import Documents.Curriculums;
import Documents.PDF;
import Interfaces.Imprimible;

public class Main {
    public static void main(String[] args) {
        Curriculums document1 = new Curriculums("CV mauricio", "Soy Buena persona");
        PDF document2 = new PDF("ADN meli", "Informacion de mel");

        Imprimible.imprimir(document1.getName(), document1.getContent());

        Imprimible.imprimir(document2.getName(), document2.getContent());
    }
}
