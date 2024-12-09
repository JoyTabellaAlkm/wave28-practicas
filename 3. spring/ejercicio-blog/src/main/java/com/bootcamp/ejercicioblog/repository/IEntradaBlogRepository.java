package com.bootcamp.ejercicioblog.repository;

import com.bootcamp.ejercicioblog.model.EntradaBlog;

import java.util.List;
import java.util.Optional;

public interface IEntradaBlogRepository {
    Long crearEntradaBlog(EntradaBlog entradaBlog);

    EntradaBlog obtenerEntradaPorId(Long id);

    List<EntradaBlog> obtenerEntradas();
}
