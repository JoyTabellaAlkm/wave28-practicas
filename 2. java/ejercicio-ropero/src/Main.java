import java.util.List;

public class Main {
    public static void main(String[] args) {

        GuardaRopa guardaRopa = new GuardaRopa(1);

        Prenda p1 = new Prenda(1, "Nike", "Zapatilla");
        Prenda p2 = new Prenda(2, "Adidas", "Remera");

        Integer idMapa = guardaRopa.guardarPrendas(List.of(p1, p2));

        System.out.println(guardaRopa.devolverPrendas(idMapa));

        guardaRopa.mostrarPrendas();

    }
}