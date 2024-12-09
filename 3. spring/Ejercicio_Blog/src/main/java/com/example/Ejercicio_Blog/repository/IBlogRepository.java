package com.example.Ejercicio_Blog.repository;

import com.example.Ejercicio_Blog.model.EntradaBlog;

import java.util.List;

public interface IBlogRepository {
    public List<EntradaBlog> listAll();

    public boolean create(EntradaBlog e);
    public int getAmountSize();
}
