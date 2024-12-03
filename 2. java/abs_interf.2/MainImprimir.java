import java.util.Arrays;

public class MainImprimir {
    public static void main(String[] args) {
        CV cv1 = new CV("Mateo", "mfe@gmail.com", Arrays.asList("Java", "Spring Boot", "SQL"));
        Libro_pdf libro1 = new Libro_pdf("ESdlA", "Tolkien", "Aventuras", 350);
        Imprimible.imprimir(libro1);
    }
}
