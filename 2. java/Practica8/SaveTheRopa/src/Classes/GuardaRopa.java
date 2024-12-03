package Classes;

import Classes.Prendas.Prenda;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {
    private int count = 0;
    private Map<Integer, List<Prenda>> prendas;

    public GuardaRopa(){
        this.prendas = new HashMap<>();
    }

    public Integer guardarPrendas(List<Prenda> listaDePrenda){
        count++;
        prendas.put(count, listaDePrenda);
        return count;
    }

    public void mostrarPrendas(){
        this.prendas.forEach((key, value) -> {
            System.out.println("Clave: " + key);
            System.out.println("Valores: ");
            mostrarLista(value);
        });
    }

    public void mostrarLista(List<Prenda> prendas) {
        prendas.forEach(prenda -> System.out.println("- " + prenda));
    }

    public List<Prenda> devolverPrendas(Integer numero){
        return this.prendas.get(numero);
    }

    //ToString

    @Override
    public String toString() {
        return "GuardaRopa{" +
                "count=" + count +
                ", prendas=" + prendas +
                '}';
    }
}
