package com.mercadolibre.blogyoutuber.service;

import com.mercadolibre.blogyoutuber.dto.BlogDTO;

import java.util.HashMap;

public interface IBlog {
    public BlogDTO crearEntrada(BlogDTO blog);
    public HashMap<Long, BlogDTO> obtenerBlogs();
    public BlogDTO obtenerBlogPorId(Long id);
}
