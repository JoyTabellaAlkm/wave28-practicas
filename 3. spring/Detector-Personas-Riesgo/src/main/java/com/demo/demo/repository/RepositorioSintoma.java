package com.demo.demo.repository;

import com.demo.demo.entity.Sintoma;

import java.util.ArrayList;
import java.util.List;

public class RepositorioSintoma {
    private List<Sintoma> sintomas = new ArrayList<>();

    public RepositorioSintoma() {
        sintomas.add(new Sintoma(1, "Fiebre", 2));
        sintomas.add(new Sintoma(2, "Dolor de cabeza", 5));
        sintomas.add(new Sintoma(3, "Dolor de garganta", 1));
    }

    public List<Sintoma> getAll() {
        return this.sintomas;
    }

    public Sintoma getSintoma(String nombre) {
        return this.sintomas.stream()
                .filter(sintoma -> sintoma.getNombre().equals(nombre))
                .findFirst()
                .orElse(null);
    }
}
