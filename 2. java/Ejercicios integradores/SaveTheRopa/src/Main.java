import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        GuardaRopa guardaRopa = new GuardaRopa();
        List<Prenda> listaPrenda1 = new ArrayList<>();
        Prenda prenda1 = new Prenda("Nike", "Tenis");
        listaPrenda1.add(prenda1);
        System.out.println(guardaRopa.guardarPrendas(listaPrenda1));

        List<Prenda> listaPrenda2 = new ArrayList<>();
        Prenda prenda2 = new Prenda("Adidas", "Tenis");
        listaPrenda2.add(prenda2);
        System.out.println(guardaRopa.guardarPrendas(listaPrenda2));

        guardaRopa.mostrarPrendas();
        System.out.println(guardaRopa.devolverPrendas(2));
    }
}