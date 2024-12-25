package com.example.blogyoutube.service;

import com.example.blogyoutube.dto.EntradaBlogDto;
import com.example.blogyoutube.dto.NewResourceDto;

import java.util.List;

public interface IEntradaBlogService {
    List<EntradaBlogDto> findAll();
    NewResourceDto createEntradaBlog(EntradaBlogDto entradaBlogDto);
    EntradaBlogDto find(long id);
}
