package ejercicios_integradores.save_the_ropa;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        GuardaRopa guardaRopa = new GuardaRopa();
        Prenda prenda1 = new Prenda("Zara", "Camiseta escote en V negra");
        Prenda prenda2 = new Prenda("Zara", "Camiseta escote en V blanca");
        Prenda prenda3 = new Prenda("Adidas", "Musculosa roja");
        Prenda prenda4 = new Prenda("Adidas", "Campera Boca Juniors");

        List<Prenda> listaPrendas1 = List.of(prenda1, prenda2);
        List<Prenda> listaPrendas2 = List.of(prenda3, prenda4);

        Integer identificadorPrendas1 = guardaRopa.guardarPrendas(listaPrendas1);
        Integer identificadorPrendas2 = guardaRopa.guardarPrendas(listaPrendas2);
        guardaRopa.mostrarPrendas();

        System.out.println("\n===== Lisandro retira sus prendas: ");
        System.out.println(guardaRopa.devolverPrendas(identificadorPrendas1));

        System.out.println("\n***** Nuevo estado del guardaropa *****\n");
        guardaRopa.mostrarPrendas();

        System.out.println("\n===== Fermin retira sus prendas: ");
        System.out.println(guardaRopa.devolverPrendas(identificadorPrendas2));

        System.out.println("\n***** Nuevo estado del guardaropa *****\n");
        guardaRopa.mostrarPrendas();
    }
}
