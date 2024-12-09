package com.mercadolibre.blog.repository;

import com.mercadolibre.blog.model.EntradaBlog;

import java.util.List;

public interface IEntradaBlogRepository {
    Long addEntradaBlog(EntradaBlog entrada);
    List<EntradaBlog> getAll();
    EntradaBlog getById(Long id);
    Boolean exists(EntradaBlog entrada);
}
