package com.bootcamp.concesionariaautos.repository;

import java.util.List;
import java.util.Optional;

public interface CrudRepository<T, K> {
    List<T> findAll();
    Optional<T> findById(K id);
    T save(T obj);
    T update(T obj);
    T deleteById(K id);
}
