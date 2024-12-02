import Clases.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Informe informe = new Informe("Lorem ipsum",8, "Dario Dominguez","Mateo Delevelle");
        LibroPDF libroPDF = new LibroPDF("Fantasía", 1000, "JK Rowling", "Harry Potter");
        Curriculum cv = new Curriculum("Paloma","Sosa","12345678", 24, new ArrayList<>());
        cv.agregarHabilidades("Responsabilidad");

        informe.imprimir();
        libroPDF.imprimir();
        cv.imprimir();
    }
}
