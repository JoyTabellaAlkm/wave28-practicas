package com.example.Blog.service;

import com.example.Blog.dto.EntradaBlogDto;

import java.util.List;

public interface IBlogService {
    public Long agregarNuevoBlog(EntradaBlogDto dto);

    public EntradaBlogDto encontrarPorId(Long id);

    public List<EntradaBlogDto> buscarTodos();
}
