package com.bootcamp.social_meli.repository;

import java.util.List;
import java.util.Optional;

public interface ICrudRepository <T, K> {
    List<T> findAll();
    Optional<T> findById(K id);
    T create(T obj);
    T delete(T obj);
}
