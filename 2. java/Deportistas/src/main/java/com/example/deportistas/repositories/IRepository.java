package com.example.deportistas.repositories;

import java.util.List;

public interface IRepository<T, F> {
    T getOne(F filterBy);
    List<T> getAll();
    boolean add(T entity);
}
