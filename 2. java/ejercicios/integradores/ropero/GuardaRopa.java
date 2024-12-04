package ejercicios.integradores.ropero;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {

    private int id;

    private Integer idMap;
    private Map<Integer, List<Prenda>> prendas;

    public GuardaRopa(int id) {
        this.id = id;
        this.prendas = new HashMap<>();
        this.idMap = 0;
    }

    public Integer guardarPrendas(List<Prenda> listaDePrenda) {
        prendas.put(idMap,listaDePrenda);
        return idMap++;
    }

    public void mostrarPrendas() {
        prendas.forEach((id, prendas) -> System.out.println("Número id de prendas: " + id + " prendas: " + prendas));
    }

    public List<Prenda> devolverPrendas(Integer numero) {
        return prendas.get(numero);
    }
}
