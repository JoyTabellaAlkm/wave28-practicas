import java.util.List;

public class Main {
    public static void main(String[] args) {
        Prenda remera = new Remera("Zara","Azul");
        Prenda pantalon = new Pantalon("Zara","Jean");

        GuardaRopa guardaRopa = new GuardaRopa();
        Integer codigo = guardaRopa.guardarPrendas(List.of(remera,pantalon));

        List<Prenda> prendas = guardaRopa.devolverPrendas(codigo);
        System.out.println(prendas);

        guardaRopa.mostrarPrendas();
    }
}