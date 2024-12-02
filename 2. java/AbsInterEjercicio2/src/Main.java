import clases.Curriculum;
import clases.Impresora;
import clases.Informe;
import clases.Libro;

public class Main {
    public static void main(String[] args) {
        Curriculum curriculum = new Curriculum("Juan", "Leer y escribir");
        Libro libro = new Libro("Libro1", "Adv", "Juanes", 132);
        Informe informe = new Informe("Nico", "Juan", 123, "algun contenido");

        Impresora.imprimir(curriculum);
        Impresora.imprimir(libro);
        Impresora.imprimir(informe);
    }
}