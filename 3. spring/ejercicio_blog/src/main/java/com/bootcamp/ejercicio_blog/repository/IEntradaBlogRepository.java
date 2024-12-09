package com.bootcamp.ejercicio_blog.repository;


import com.bootcamp.ejercicio_blog.entity.EntradaBlog;

import java.util.List;
import java.util.Optional;

public interface IEntradaBlogRepository {
    List<EntradaBlog> getAll();
    Optional<EntradaBlog> getById(String id);
    EntradaBlog save(EntradaBlog entradaBlog);
}
