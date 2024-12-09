package com.mercadolibre.Blog.repository;

import com.mercadolibre.Blog.entity.EntradaBlogEntity;

import java.util.List;

public interface IBlogRepository {
    public EntradaBlogEntity filterById(int id);
    public EntradaBlogEntity agregarEntrada( EntradaBlogEntity entrada);
    public List<EntradaBlogEntity> listarTodas();
}
