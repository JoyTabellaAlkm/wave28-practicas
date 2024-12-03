
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {
    private int contadorListasPrenda = 1;
    private Map<Integer, List<Prenda>> mapaListaPrendas;

    public GuardaRopa() {
        this.mapaListaPrendas = new HashMap<>();
    }

    public GuardaRopa(HashMap<Integer, List<Prenda>> listaPrenda) {
        this.mapaListaPrendas = listaPrenda;
    }

    public Integer guardarPrendas(List<Prenda> listaDePrenda) {
        int nroIdentificador = this.contadorListasPrenda;
        this.mapaListaPrendas.put(this.contadorListasPrenda, listaDePrenda);
        this.contadorListasPrenda++;
        return nroIdentificador;
    }

    public void mostrarPrendas() {
        if (this.mapaListaPrendas.isEmpty()) {
            System.out.println("El guardaropas se encuentra vacío...");
        } else {
            this.mapaListaPrendas.forEach((key, listaItem) -> {
                System.out.println("===== IDENTIFICADOR #" + key + " =====");
                listaItem.forEach(System.out::println);
            });
        }
    }

    public List<Prenda> devolverPrendas(Integer numeroIdentificador) {
        return this.mapaListaPrendas.remove(numeroIdentificador);
    }

    public Map<Integer, List<Prenda>> getMapaListaPrendas() {
        return mapaListaPrendas;
    }

    public void setMapaListaPrendas(Map<Integer, List<Prenda>> mapaListaPrendas) {
        this.mapaListaPrendas = mapaListaPrendas;
    }
}