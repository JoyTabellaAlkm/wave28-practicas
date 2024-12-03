import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {
    Map<Integer, List<Prenda>> prendas;
    Integer index = 0;

    public GuardaRopa() {
        prendas = new HashMap<>();
    }

    public Integer guardarPrendas(List<Prenda> listaDePrenda){
        index++;
        prendas.put(index, listaDePrenda);
        return index;
    }

    public void mostrarPrendas(){
        this.prendas.forEach(this::mostrarPrendasPorCodigo);
    }

    private void mostrarPrendasPorCodigo(Integer key, List<Prenda> value){
        System.out.println("Clave: " + key);
        System.out.println("    Prendas: ");
        value.forEach(prenda -> System.out.println("    - " + prenda));
    }

    public List<Prenda> devolverPrendas(Integer numero){
        return prendas.get(numero);
    }
}
//