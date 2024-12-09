package com.example.youtubeblog.service.impl;

import com.example.youtubeblog.dto.EntradaBlogDto;
import com.example.youtubeblog.exception.ConflictException;
import com.example.youtubeblog.exception.NotFoundException;
import com.example.youtubeblog.model.EntradaBlog;
import com.example.youtubeblog.repository.IEntradaBlogRepository;
import com.example.youtubeblog.service.IEntradaBlogService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EntradaBlogService implements IEntradaBlogService {
    private final ObjectMapper objectMapper;
    private final IEntradaBlogRepository entradaBlogRepository;

    public EntradaBlogService(ObjectMapper objectMapper, IEntradaBlogRepository entradaBlogRepository) {
        this.objectMapper = objectMapper;
        this.entradaBlogRepository = entradaBlogRepository;
    }

    @Override
    public List<EntradaBlogDto> getAll() {
        return entradaBlogRepository.getAll().stream()
                .map(v -> objectMapper.convertValue(v, EntradaBlogDto.class))
                .toList();
    }

    @Override
    public EntradaBlogDto getById(String id) {
        return entradaBlogRepository.getById(id)
                .map(e -> objectMapper.convertValue(e, EntradaBlogDto.class))
                .orElseThrow(() -> new NotFoundException("No existe una entrada con el id: " + id));
    }

    @Override
    public EntradaBlogDto addNew(EntradaBlogDto entradaBlogDto) {
        entradaBlogRepository.getById(entradaBlogDto.getIdBlog())
                .ifPresent(existing -> {
                    throw new ConflictException("Ya existe una entrada blog con el id : " + entradaBlogDto.getIdBlog());
                });

        EntradaBlog entradaBlog = objectMapper.convertValue(entradaBlogDto, EntradaBlog.class);
        entradaBlogRepository.save(entradaBlog);

        return entradaBlogDto;
    }
}
