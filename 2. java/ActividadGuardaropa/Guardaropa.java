import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Guardaropa {
    private Map<Integer, List<Prenda>> cajon;
    private int contador = 0;

    public Guardaropa() {
        this.cajon = new HashMap<>();
    }

    public Guardaropa(Map<Integer, List<Prenda>> cajon) {
        this.cajon = cajon;
    }

    public Map<Integer, List<Prenda>> getCajon() {
        return cajon;
    }

    public void setCajon(Map<Integer, List<Prenda>> cajon) {
        this.cajon = cajon;
    }

    public Integer guardarPrendas(List<Prenda> listaDePrenda){
        contador++;
        this.cajon.put(contador, listaDePrenda);
        return contador;
    }

    public void mostrarPrendas(){
        for (Map.Entry<Integer, List<Prenda>> entrada : cajon.entrySet()) {
            Integer clave = entrada.getKey();     // Obtener la clave
            List<Prenda> valor = entrada.getValue();   // Obtener el valor

            // Imprimir la clave y el valor
            System.out.println("Las prendas que tenemos son Clave: " + clave + ", Valor: " + valor.toString());

        }
    }

    public List<Prenda> devolverPrendas(Integer numero){
        List<Prenda> valor = this.cajon.get(numero);
        return valor;
    }
}
