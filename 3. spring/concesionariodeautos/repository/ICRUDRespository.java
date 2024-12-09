package com.mercadolibre.concesionariodeautos.repository;

import java.util.List;
import java.util.Optional;

public interface ICRUDRespository <T, K> {
    List<T> readAll();
    Optional<T> readById(K id);
    T create(T obj);
    T update(T obj);
    T deleteById(K id);
}