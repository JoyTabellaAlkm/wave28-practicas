package com.example.EjerciciosIntegradores_parte1.SaveTheRopa;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Guardarropa {
    private Map<Integer, List<Prenda>> mapaGuardarropa;
    private Integer contador;

    public Guardarropa() {
        mapaGuardarropa = new HashMap<>();
        contador = 0;
    }

    public Map<Integer, List<Prenda>> getMapaGuardarropa() {
        return mapaGuardarropa;
    }

    public void setMapaGuardarropa(Map<Integer, List<Prenda>> mapaGuardarropa) {
        this.mapaGuardarropa = mapaGuardarropa;
    }

    public Integer getContador() {
        return contador;
    }

    public void setContador(Integer contador) {
        this.contador = contador;
    }

    public Integer guardarPrenda (List<Prenda> listaPrenda){
        contador++;
        mapaGuardarropa.put(contador, listaPrenda);
        System.out.println("numero identificador: " + contador);
        return contador;
    }

    public void mostrarPrendas (){
        System.out.println("Todas las prendas guardadas");
        mapaGuardarropa.entrySet().stream().forEach(g -> {
                    System.out.println("prendas guardadas con el identificador: " + g.getKey());
                    System.out.println(g.getValue());
                    System.out.println("---------------------------");
                });

    }
}
