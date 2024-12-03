import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {
    private static Integer contador = 0;
    private Map<Integer, List<Prenda>> espacio = new HashMap<>();

    public GuardaRopa() {
    }

    public Integer guardarPrendas(List<Prenda> listaDePrenda) {
        contador++;
        espacio.put(contador, listaDePrenda);
        return contador;
    }

    public void mostrarPrendas() {
        espacio.forEach((k, v) -> {
            System.out.println("Nro: " + k);
            v.forEach(System.out::println);
        });
    }

    public List<Prenda> devolverPrendas(Integer numero){
        List<Prenda> devolver = espacio.get(numero);
        espacio.remove(numero);
        return devolver;
    }
}
