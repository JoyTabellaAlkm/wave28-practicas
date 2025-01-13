import model.Prenda;
import repository.GuardaRopaImp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        Map<Integer, List<Prenda>> prendasMap = new HashMap<>();

        Integer contadorInicial = 0;

        GuardaRopaImp guardaRopaImp = new GuardaRopaImp(prendasMap, contadorInicial);

        Prenda prenda1 = new Prenda("Nike", "Camiseta");
        Prenda prenda2 = new Prenda("Adidas", "Pantalón");

        List<Prenda> listaDePrendas = new ArrayList<>();
        listaDePrendas.add(prenda1);
        listaDePrendas.add(prenda2);

        Integer codigo = guardaRopaImp.guardarPrendas(listaDePrendas);
        System.out.println("Prendas guardadas con el código: " + codigo);

        System.out.println("Contenido del guardarropa:");
        guardaRopaImp.mostrarPrendas();

        List<Prenda> prendasRecuperadas = guardaRopaImp.devolverPrendas(codigo);
        System.out.println("Prendas recuperadas: " + prendasRecuperadas);

        System.out.println("Contenido del guardarropa después de retirar prendas:");
        guardaRopaImp.mostrarPrendas();
    }
}