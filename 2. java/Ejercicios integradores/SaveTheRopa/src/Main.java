import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        GuardaRopa guardaRopa = new GuardaRopa();
        List<Prenda> Prendas = new ArrayList<>();
        Prenda prenda1 = new Prenda("Nike", "Tenis");
        Prenda prenda2 = new Prenda("Adidas", "Tenis");
        Prendas.add(prenda1);
        Prendas.add(prenda2);

        System.out.println(guardaRopa.guardarPrendas(Prendas));

        guardaRopa.mostrarPrendas();

        System.out.println(guardaRopa.devolverPrendas(1));
    }
}