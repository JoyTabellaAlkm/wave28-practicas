package com.bootcamp.ejercicioblog.service;

import com.bootcamp.ejercicioblog.controller.EntradaBlogRestController;
import com.bootcamp.ejercicioblog.model.EntradaBlog;

import java.util.List;
import java.util.Optional;

public interface IEntradaBlogService {
    Long crearEntradaBlog(EntradaBlog entradaBlog);

    EntradaBlog obtenerEntradaPorId(Long id);

    List<EntradaBlog> obtenerEntradas();
}
