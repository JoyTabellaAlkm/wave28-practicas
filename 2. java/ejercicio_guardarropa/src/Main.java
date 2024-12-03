import java.util.List;

public class Main {
    public static void main(String[] args) {
        Prenda remera = new Remera("Zara","Manga larga");
        Prenda pantalon = new Pantalon("H&M","Jean");

        GuardaRopa guardaRopa = new GuardaRopa();
        Integer codigo = guardaRopa.guardarPrendas(List.of(remera,pantalon));

        List<Prenda> prendas = guardaRopa.devolverPrendas(codigo);
        System.out.println(prendas);

        guardaRopa.mostrarPrendas();
    }
}