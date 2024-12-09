package com.example.blogyoutube.repository;

import com.example.blogyoutube.entity.EntradaBlog;

import java.util.List;
import java.util.Optional;

public interface IEntradaBlogRepository {
    List<EntradaBlog> findAll();
    EntradaBlog create(EntradaBlog entradaBlog);
    Optional<EntradaBlog> find(long id);
}
