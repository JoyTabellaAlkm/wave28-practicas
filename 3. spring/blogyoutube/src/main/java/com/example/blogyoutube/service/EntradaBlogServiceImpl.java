package com.example.blogyoutube.service;

import com.example.blogyoutube.dto.EntradaBlogDto;
import com.example.blogyoutube.dto.NewResourceDto;
import com.example.blogyoutube.entity.EntradaBlog;
import com.example.blogyoutube.exception.NotFoundException;
import com.example.blogyoutube.repository.IEntradaBlogRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EntradaBlogServiceImpl implements IEntradaBlogService {

    @Autowired
    IEntradaBlogRepository entradaBlogRepository;

    @Override
    public List<EntradaBlogDto> findAll() {
        ObjectMapper objectMapper = new ObjectMapper();
        List<EntradaBlog> entradaBlogs = entradaBlogRepository.findAll();

        if (entradaBlogs.isEmpty())
            throw new NotFoundException("No se encontraron blogs creados");

        return entradaBlogs.stream()
                .map(e -> objectMapper.convertValue(e, EntradaBlogDto.class))
                .toList();
    }

    @Override
    public NewResourceDto createEntradaBlog(EntradaBlogDto entradaBlogDto) {
        ObjectMapper objectMapper = new ObjectMapper();
        EntradaBlog entradaBlog = entradaBlogRepository.create(
                objectMapper.convertValue(entradaBlogDto, EntradaBlog.class));

        return new NewResourceDto("El recurso se ha creado exitosamente", "/blogs/" + entradaBlog.getId());
    }

    @Override
    public EntradaBlogDto find(long id) {
        ObjectMapper objectMapper = new ObjectMapper();
        Optional<EntradaBlog> entradaBlog = entradaBlogRepository.find(id);

        if (entradaBlog.isPresent())
            return objectMapper.convertValue(entradaBlog.get(), EntradaBlogDto.class);

        throw new NotFoundException("No se encontro el recurso con id: " + id);
    }
}
