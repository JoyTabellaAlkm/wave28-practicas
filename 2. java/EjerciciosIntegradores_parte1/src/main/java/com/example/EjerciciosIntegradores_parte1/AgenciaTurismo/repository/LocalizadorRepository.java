package com.example.EjerciciosIntegradores_parte1.AgenciaTurismo.repository;

import com.example.EjerciciosIntegradores_parte1.AgenciaTurismo.domain.Localizador;

public class LocalizadorRepository extends GenericRepository<Localizador,Integer>{
    @Override
    public Localizador buscarPorId(Integer id){
        return this.obtenerTodos().stream().filter(l->l.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public void crear(Localizador obj) {
        this.obtenerTodos().add(obj);
    }
}
