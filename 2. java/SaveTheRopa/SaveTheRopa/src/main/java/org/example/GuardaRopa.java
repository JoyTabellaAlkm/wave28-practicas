package org.example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {
    private static Integer contador=0;
    private Map<Integer, List<Prenda>> ropaGuardada = new HashMap<>();
    public static Integer getContador() {
        return contador;
    }
    public static void setContador(Integer contador) {
        GuardaRopa.contador = contador;
    }
    public Map<Integer, List<Prenda>> getRopaGuardada() {
        return ropaGuardada;
    }
    public void setRopaGuardada(Map<Integer, List<Prenda>> ropaGuardada) {
        this.ropaGuardada = ropaGuardada;
    }
    public Integer guardarPrendas(List<Prenda> listaDePrenda){
        contador++;
        ropaGuardada.put(contador, listaDePrenda);
        return contador;
    }
    public void mostrarPrendas(){
        ropaGuardada.forEach((k, v) -> {
            System.out.println("Nro: " + k);
            v.forEach(System.out::println);
        });
    }
    public List<Prenda> devolverPrendas(Integer numero){
        List<Prenda> prenda = ropaGuardada.get(numero);
        ropaGuardada.remove(numero);
        return prenda;
    }
}
