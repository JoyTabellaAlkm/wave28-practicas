package com.mercadolibre.blog.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.blog.dto.EntradaBlogDto;
import com.mercadolibre.blog.exception.DuplicatedEntryException;
import com.mercadolibre.blog.exception.InvalidPathVariableException;
import com.mercadolibre.blog.exception.NotFoundException;
import com.mercadolibre.blog.model.EntradaBlog;
import com.mercadolibre.blog.repository.IEntradaBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EntradaBlogServiceImpl implements IEntradaBlogService{
    @Autowired
    private IEntradaBlogRepository entradaBlogRepository;
    @Autowired
    ObjectMapper mapper;

    @Override
    public Long addEntradaBlog(EntradaBlogDto entradaDto) {
        EntradaBlog entrada= mapper.convertValue(entradaDto, EntradaBlog.class);
        if (entradaBlogRepository.exists(entrada))throw new DuplicatedEntryException("Entrada de blog existente");
        return entradaBlogRepository.addEntradaBlog(entrada);
    }

    @Override
    public List<EntradaBlogDto> getAll() {
        List<EntradaBlogDto> listDto = mapper.convertValue(entradaBlogRepository.getAll(), new TypeReference<List<EntradaBlogDto>>() {
        });
        return listDto;
    }

    @Override
    public EntradaBlogDto getById(String entityId) {
        Long id;
        try {
            id = Long.parseLong(entityId);
        }catch (NumberFormatException e){
            throw new InvalidPathVariableException("Ingrese un id valido");
        }
        EntradaBlogDto entradaBlogDto = mapper.convertValue(entradaBlogRepository.getById(id),EntradaBlogDto.class);
        if (entradaBlogDto == null)throw new NotFoundException("Entrada de blog inexistente");
        return entradaBlogDto;
    }
}
