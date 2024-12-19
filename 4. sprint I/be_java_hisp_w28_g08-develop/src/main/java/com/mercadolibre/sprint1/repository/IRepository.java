package com.mercadolibre.sprint1.repository;

import java.util.List;

public interface IRepository<T> {

	List<T> findAll();

	T save(T entity);

	boolean delete(int id);

	boolean delete(T entity);
}
