package com.mercadolibre.Blog.service;

import com.mercadolibre.Blog.dto.BlogDTO;
import com.mercadolibre.Blog.entity.EntradaBlogEntity;

import java.util.List;

public interface IBlogService {
    public BlogDTO filterById(int id);
    public BlogDTO agregarEntrada( BlogDTO entrada);
    public List<BlogDTO> listarTodas();
}
