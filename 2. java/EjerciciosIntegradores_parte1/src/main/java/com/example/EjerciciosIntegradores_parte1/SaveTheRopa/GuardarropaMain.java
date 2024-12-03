package com.example.EjerciciosIntegradores_parte1.SaveTheRopa;

import java.util.ArrayList;
import java.util.List;

public class GuardarropaMain {
    public static void main(String[] args) {
        Guardarropa guardarropa = new Guardarropa();

        Prenda nuevaPrenda = new Prenda("Levi", "Chomba", 1);
        Prenda nuevaPrenda1 = new Prenda("JC", "Campera", 2);
        Prenda nuevaPrenda2 = new Prenda("Adidas", "Zapas", 3);
        Prenda nuevaPrenda3 = new Prenda("Nike", "Pantalon", 4);


        List<Prenda> listaPrenda = new ArrayList<>();

        listaPrenda.add(nuevaPrenda);
        listaPrenda.add(nuevaPrenda1);
        listaPrenda.add(nuevaPrenda2);
        listaPrenda.add(nuevaPrenda3);

        guardarropa.guardarPrenda(listaPrenda);

        guardarropa.mostrarPrendas();

    }
}
