import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {
    Map<Integer, List<Prenda>> diccionario;
    int identificador;

    public GuardaRopa() {
        this.diccionario = new HashMap<>();
        this.identificador = 1;
    }

    public Map<Integer, List<Prenda>> getDiccionario() {
        return diccionario;
    }

    public void setDiccionario(Map<Integer, List<Prenda>> diccionario) {
        this.diccionario = diccionario;
    }

    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public Integer guardarPrendas(List<Prenda> listaDePrenda){
        diccionario.put(identificador, listaDePrenda);
        identificador++;
        return (identificador - 1);
    }

    public void mostrarPrendas(){
        diccionario.entrySet().stream()
                .forEach(prendasList -> System.out.println("-" + prendasList.getKey() + prendasList.getValue()));
    }

    public List<Prenda> devolverPrendas(Integer numero){
        return diccionario.entrySet().stream()
                .filter(prendaAConsultar -> prendaAConsultar.getKey().equals(numero))
                .map(Map.Entry::getValue)
                .findFirst()
                .orElse(null);
    }
}
