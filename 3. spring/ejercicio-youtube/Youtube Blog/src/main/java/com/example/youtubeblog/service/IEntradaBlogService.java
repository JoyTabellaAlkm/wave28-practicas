package com.example.youtubeblog.service;

import com.example.youtubeblog.dto.EntradaBlogDto;

import java.util.List;

public interface IEntradaBlogService {
    List<EntradaBlogDto> getAll();
    EntradaBlogDto getById(String id);
    EntradaBlogDto addNew(EntradaBlogDto entradaBlog);
}
