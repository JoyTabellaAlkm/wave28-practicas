package com.example.EjerciciosIntegradores_parte1.AgenciaTurismo.repository;

import com.example.EjerciciosIntegradores_parte1.AgenciaTurismo.domain.*;

public class ClienteRepository extends GenericRepository<Cliente, String> {
    @Override
    public Cliente buscarPorId(String id) {
        return this.listObjetos.stream().filter(c -> c.getDni().equals(id)).findFirst().orElse(null);
    }

    @Override
    public void crear(Cliente obj) {
        this.listObjetos.add(obj);
        System.out.println("-- Se ha agregado al cliente " + obj);
    }
}
