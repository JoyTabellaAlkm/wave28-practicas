package com.mercadolibre.covid19.repository;

import java.util.List;
import java.util.Optional;

public interface ICrudRepository<T>{
    T save(T t);
    Optional<T> findById(Long id);
    List<T> findAll();
    String delete(Long id);
}
