package com.mercadolibre.calculadoracalorias.model;

import lombok.Data;

import java.util.Comparator;
import java.util.List;

@Data
public class Plato {
    private String nombre;
    private List<Ingrediente> ingredientes;

    public Integer getCaloriasTotales(){
        return ingredientes.stream().mapToInt(i->i.getCalorias()).sum();
    }
    public Ingrediente getMasCalorico(){
        return ingredientes.stream().sorted((i1,i2)->i1.getCalorias()-i2.getCalorias()).findFirst().orElse(null);
    }
}
