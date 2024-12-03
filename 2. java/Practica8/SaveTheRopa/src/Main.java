import Classes.GuardaRopa;
import Classes.Prendas.*;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Prenda prenda1 = new Campera("Nike", "Jordan Jumpman");
        Prenda prenda2 = new Buzo("Nike", "Sportswear Club");

        GuardaRopa guardaRopa = new GuardaRopa();
        Integer code1 = guardaRopa.guardarPrendas(List.of(prenda1, prenda2));
        System.out.println("Codigo de prendas: " + code1);
        System.out.println("\nPrendas en el guardarropas: ");
        guardaRopa.mostrarPrendas();
        List<Prenda> prendas1 = guardaRopa.devolverPrendas(code1);
        System.out.println("\nPrendas del usuario: ");
        prendas1.forEach(System.out::println);

    }
}