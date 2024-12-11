package com.mercadolibre.youtuveblogs.repository;

import com.mercadolibre.youtuveblogs.model.EntradaBlog;

import java.util.List;
import java.util.Optional;

public interface IEntradaBlogRepository {
    List<EntradaBlog> getAll();
    Optional<EntradaBlog> getById(String id);
    EntradaBlog save(EntradaBlog entradaBlog);
}
