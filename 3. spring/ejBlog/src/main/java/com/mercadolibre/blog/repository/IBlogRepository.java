package com.mercadolibre.blog.repository;

import com.mercadolibre.blog.model.EntradaBlog;

public interface IBlogRepository {
    public EntradaBlog findById(Integer id);

    public String create(EntradaBlog blog);
}
