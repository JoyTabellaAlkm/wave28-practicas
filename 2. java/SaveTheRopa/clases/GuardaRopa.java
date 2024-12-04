package clases;

import java.util.List;
import java.util.Map;

public class GuardaRopa {
    private int id;
    private Map<Integer, List<Prenda>> listaDePrendas;

    public GuardaRopa(int id, Map<Integer, List<Prenda>> listaDePrendas){
        this.id = id;
        this.listaDePrendas = listaDePrendas;
    }

    public Integer guardarPrendas(List<Prenda> listaDePrenda){
        this.id = this.listaDePrendas.size() + 1;
        this.listaDePrendas.put(this.id, listaDePrenda);
        return this.id;
    }

    public void mostrarPrendas(){
        this.listaDePrendas.forEach((key, prendas)-> {
            System.out.println("Id: " + key);
            prendas.stream().forEach(prenda -> {
                System.out.println(prenda);
            });
        });
    }

    public List<Prenda> devolverPrendas(Integer numero){
        return this.listaDePrendas.get(numero);
    }
}
