package com.mercadolibre.localizadores;

import java.util.ArrayList;
import java.util.List;

public class Repositorio {

    private List<Localizador> compras;

    public Repositorio() {
        compras = new ArrayList<>();
    }

    public void agregarCompra(Localizador localizador) {
        localizador.calcularTotal();
        compras.add(localizador);
    }

    public int totalCompras() {
        return compras.size();
    }

}
