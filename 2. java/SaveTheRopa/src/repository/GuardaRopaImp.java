package repository;

import model.Prenda;

import java.util.List;
import java.util.Map;

public class GuardaRopaImp implements IGuardaRopa{
    private Map<Integer, List<Prenda>> prendas;
    private Integer contador;

    public GuardaRopaImp(Map<Integer, List<Prenda>> prendas, Integer contador) {
        this.prendas = prendas;
        this.contador = contador;
    }

    @Override
    public Integer guardarPrendas(List<Prenda> listaDePrenda) {
        contador++;
        prendas.put(contador, listaDePrenda);
        return contador;
    }

    @Override
    public void mostrarPrendas() {
        for (Map.Entry<Integer, List<Prenda>> entry : prendas.entrySet()) {
            System.out.println("Código: " + entry.getKey() + ", Prendas: " + entry.getValue());
        }
    }

    @Override
    public List<Prenda> devolverPrendas(Integer numero) {
        return prendas.remove(numero);
    }
}
