package Entities;

import java.util.Dictionary;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {
    // ATTRIBUTES
    private Map<Integer, List<Prenda>> diccionario;
    private Integer contadorDiccionario;

    // CONSTRUCTOR
    public GuardaRopa() {
        diccionario = new HashMap<>();
        contadorDiccionario = 0;
    }

    public GuardaRopa( List<Prenda> diccionario) {
        this.diccionario = new HashMap<>();
        contadorDiccionario = 0;
        this.diccionario.put(contadorDiccionario, diccionario);
    }

    // METHODS
    public Integer guardarPrendas(List<Prenda> listaDePrenda){
        diccionario.put(contadorDiccionario, listaDePrenda);
        contadorDiccionario++;
        return contadorDiccionario-1;
    }

    public void mostrarPrendas(){
        diccionario.forEach((x,y) -> {
            System.out.println(x);
            System.out.println(y);
        });
    }

    public List<Prenda> devolverPrendas(Integer numero){
        return diccionario.get(numero);
    }

    // TO STRING
    @Override
    public String toString() {
        return "GuardaRopa{" +
                "diccionario=" + diccionario +
                ", contadorDiccionario=" + contadorDiccionario +
                '}';
    }

    // GETS & SETS
    public Map<Integer, List<Prenda>> getDiccionario() {
        return diccionario;
    }

    public void setDiccionario(Map<Integer, List<Prenda>> diccionario) {
        diccionario = diccionario;
    }

    public int getContadorDiccionario() {
        return contadorDiccionario;
    }

    public void setContadorDiccionario(int contadorDiccionario) {
        contadorDiccionario = contadorDiccionario;
    }
}
