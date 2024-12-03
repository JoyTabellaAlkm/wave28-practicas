import Entities.GuardaRopa;
import Entities.Prenda;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Prenda prenda1 = new Prenda("John Foos", "Remera");
        Prenda prenda2 = new Prenda("Adidas", "Zapatillas");
        Prenda prenda3 = new Prenda("Nike", "Pantalon");

        List<Prenda> prendas = new ArrayList<>();

        prendas.add(prenda1);
        prendas.add(prenda2);
        prendas.add(prenda3);

        GuardaRopa guardaRopa = new GuardaRopa(prendas);

        //System.out.println(guardaRopa);

        guardaRopa.mostrarPrendas();
        System.out.println(guardaRopa.devolverPrendas(0));
    }
}
