package com.ejercicioblog.blog.repository;

import com.ejercicioblog.blog.entity.EntradaBlogEntity;

import java.util.List;

public interface IBlogRepository {
    public EntradaBlogEntity filterById(int id);
    public EntradaBlogEntity agregarEntrada(EntradaBlogEntity entrada);
    public List<EntradaBlogEntity> listarTodas();
}
