import java.util.List;

public class Main {
    public static void main(String[] args) {
        Curriculum curriculum = new Curriculum("Andres", List.of(new String[]{"Java", "Angular"}));
        Informe informe = new Informe("Camilo", 10);
        Libro libro = new Libro("J.R.R Tolkien",300,"El Señor de los Anillos","Fantasia");
        curriculum.imprimir();;
        informe.imprimir();
        libro.imprimir();
    }
}
