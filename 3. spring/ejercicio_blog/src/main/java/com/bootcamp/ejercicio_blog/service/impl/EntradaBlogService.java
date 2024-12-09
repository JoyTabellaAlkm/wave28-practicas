package com.bootcamp.ejercicio_blog.service.impl;

import com.bootcamp.ejercicio_blog.dto.EntradaBlogDto;
import com.bootcamp.ejercicio_blog.exception.ConflictException;
import com.bootcamp.ejercicio_blog.exception.NotFoundException;
import com.bootcamp.ejercicio_blog.entity.EntradaBlog;
import com.bootcamp.ejercicio_blog.repository.IEntradaBlogRepository;
import com.bootcamp.ejercicio_blog.service.IEntradaBlogService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntradaBlogService implements IEntradaBlogService {
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private IEntradaBlogRepository entradaBlogRepository;


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
