package com.mercadolibre.youtuveblogs.service;

import com.mercadolibre.youtuveblogs.dto.EntradaBlogDto;

import java.util.List;

public interface IEntradaBlogService {
    List<EntradaBlogDto> getAll();
    EntradaBlogDto getById(String id);
    EntradaBlogDto addNew(EntradaBlogDto entradaBlog);
}
