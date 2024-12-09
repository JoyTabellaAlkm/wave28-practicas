package com.mercadolibre.blog.service;

import com.mercadolibre.blog.dto.EntradaBlogDto;

import java.util.List;

public interface IEntradaBlogService {
    Long addEntradaBlog(EntradaBlogDto entrada);
    List<EntradaBlogDto> getAll();
    EntradaBlogDto getById(String id);
}
