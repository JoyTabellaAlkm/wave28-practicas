package com.example.EjerciciosIntegradores_parte1.AgenciaTurismo.repository;

import java.util.ArrayList;
import java.util.List;

public abstract class GenericRepository<T,K>{
    protected List<T> listObjetos;

    public GenericRepository() {
        this.listObjetos = new ArrayList<>();
    }
    public List<T> obtenerTodos(){
        return this.listObjetos;
    }
    public abstract T buscarPorId(K id);
    public abstract void crear(T obj);
}