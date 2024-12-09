package com.bootcamp.ejercicio_blog.service;


import com.bootcamp.ejercicio_blog.dto.EntradaBlogDto;

import java.util.List;

public interface IEntradaBlogService {
    List<EntradaBlogDto> getAll();
    EntradaBlogDto getById(String id);
    EntradaBlogDto addNew(EntradaBlogDto entradaBlog);
}
