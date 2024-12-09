package com.dario.dominguez.practicaentradablog.service;

import com.dario.dominguez.practicaentradablog.dto.EntradaBlogDto;
import com.dario.dominguez.practicaentradablog.entity.EntradaBlog;

import java.util.List;

public interface IBlogService {
    public Long agregarNuevoBlog(EntradaBlogDto dto);

    public EntradaBlogDto encontrarPorId(Long id);

    public List<EntradaBlogDto> buscarTodos();
}
