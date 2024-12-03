package com.mercadolibre.clientes;

import java.util.HashMap;
import java.util.Map;

import com.mercadolibre.localizadores.Localizador;
import com.mercadolibre.localizadores.Repositorio;

public class ClienteRepositorio {

    private Map<Cliente, Repositorio> repo;

    public ClienteRepositorio() {
        repo = new HashMap<>();
    }

    public Map<Cliente, Repositorio> getRepo() {
        return repo;
    }

    public void setRepo(Map<Cliente, Repositorio> repo) {
        this.repo = repo;
    }

    public void crearLocalizador(Cliente cliente, Localizador localizador) {
        if (repo.get(cliente) == null) {
            repo.put(cliente, new Repositorio());
        }

        repo.get(cliente).agregarCompra(localizador);
        if (repo.get(cliente).totalCompras() > 2) {
            localizador.setTotal(localizador.getTotal() * 0.95);
        }

        System.out.println(localizador);
    }

}
