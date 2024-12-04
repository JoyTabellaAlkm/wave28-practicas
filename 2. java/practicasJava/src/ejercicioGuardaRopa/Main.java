package ejercicioGuardaRopa;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        GuardaRopa guardaRopa = new GuardaRopa();

        Prenda prenda1 = new Prenda("Nike","SB");
        Prenda prenda2 = new Prenda("Nike", "ACG");
        List<Prenda> prendas = List.of(prenda1,prenda2);

        Integer codigoDeGuardado = guardaRopa.guardarPrendas(prendas);

        guardaRopa.mostrarPrendas();

        List<Prenda> prendasConsultadas = guardaRopa.devolverPrendas(codigoDeGuardado);

        prendasConsultadas.stream().forEach(System.out::println);

    }
}
