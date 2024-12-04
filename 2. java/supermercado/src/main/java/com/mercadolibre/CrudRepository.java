package com.mercadolibre;

import java.util.List;

public interface CrudRepository<T, K> {

    public T save(T forSave);

    public T update(K key, T forUpdate);

    public T delete(K key);

    public List<T> findAll();

    public T findByKey(K key);

}
