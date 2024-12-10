package com.bootcamp.youtuber.repository;

import com.bootcamp.youtuber.dto.EntradaBlogDto;

import java.util.List;
import java.util.Optional;

public interface EntradaBlogDao {
    Optional<EntradaBlogDto> findById(Long id);
    void save(EntradaBlogDto entradaBlog);
    List<EntradaBlogDto> findAll();
}
