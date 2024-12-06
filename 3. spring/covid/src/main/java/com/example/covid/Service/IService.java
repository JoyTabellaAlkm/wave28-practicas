package com.example.covid.Service;

import java.util.List;

public interface IService <T>{

    T obtener(int id);
    void crear(T t);
    void eliminar(int id);
    void editar(int id, T t);
    List<T> obtenerTodos();
}
