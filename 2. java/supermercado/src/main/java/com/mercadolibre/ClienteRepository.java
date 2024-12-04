package com.mercadolibre;

import java.util.List;
import java.util.Map;

public class ClienteRepository implements CrudRepository<Cliente, String> {

    private Map<String, Cliente> clientes = Map.of();

    private boolean exists(String key) {
        return clientes.containsKey(key);
    }

    @Override
    public Cliente save(Cliente forSave) {
        if (exists(forSave.getDni())) {
            return null;
        }

        clientes.put(forSave.getDni(), forSave);
        return forSave;
    }

    @Override
    public Cliente update(String key, Cliente forUpdate) {
        if (!exists(key)) {
            return null;
        }

        clientes.put(key, forUpdate);
        return forUpdate;
    }

    @Override
    public Cliente delete(String key) {
        if (!exists(key)) {
            return null;
        }

        return clientes.remove(key);
    }

    @Override
    public List<Cliente> findAll() {
        return clientes.values()
                .stream()
                .toList();
    }

    @Override
    public Cliente findByKey(String key) {
        return clientes.get(key);
    }

}
