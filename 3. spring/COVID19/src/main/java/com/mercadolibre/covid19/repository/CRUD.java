package com.mercadolibre.covid19.repository;

import java.util.List;

public interface CRUD<T> {
    public List<T> buscar();
    public T buscarPorNombre(String nombre);
}
