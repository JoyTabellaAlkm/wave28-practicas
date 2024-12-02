package streams;

import java.util.List;

public class StreamPractice {
    public static void main(String[] args) {
        List<String> nombres = List.of("Lucas", "Alejandro", "David", "Jessica", "Erica", "Agustina");
        // Imprimo de manera "clásica"
        System.out.println("=== Lista de nombres ===");
        for (String nombre : nombres) {
            System.out.println(nombre);
        }
        // Imprimo filtrando y utilizando streams
        System.out.println("=== Ordenados ===");
        nombres.stream().sorted(String::compareToIgnoreCase).forEach(System.out::println);
    }
}
