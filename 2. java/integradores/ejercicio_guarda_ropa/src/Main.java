import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        GuardaRopa guardaRopa =new GuardaRopa();

        Prenda prenda1 = new Prenda("marca1","modelo1");
        Prenda prenda2 = new Prenda("marca2","modelo2");
        Prenda prenda3 = new Prenda("marca3","modelo3");
        Prenda prenda4 = new Prenda("marca4","modelo4");

        List<Prenda> prendasList = new ArrayList<>();
        prendasList.add(prenda1);
        prendasList.add(prenda2);
        prendasList.add(prenda3);
        prendasList.add(prenda4);


        Integer codigoDePrendas = guardaRopa.guardarPrendas(prendasList);
        guardaRopa.guardarPrendas(prendasList);

        guardaRopa.mostrarPrendas();
        System.out.println();

        List<Prenda> prendasDevueltas = guardaRopa.devolverPrendas(codigoDePrendas);

        guardaRopa.mostrarPrendas();
        System.out.println();
        prendasDevueltas.forEach(System.out::println);
    }
}