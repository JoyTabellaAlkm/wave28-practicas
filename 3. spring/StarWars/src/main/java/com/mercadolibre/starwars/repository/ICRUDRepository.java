package com.mercadolibre.starwars.repository;

import java.util.List;

public interface ICRUDRepository<T> {
    public List<T> buscarPorNombre(String nombre);
}
