package com.example.Ejercicio_Blog.service;

import com.example.Ejercicio_Blog.dto.EntradaBlogDto;
import com.example.Ejercicio_Blog.exception.IdExistenteException;
import com.example.Ejercicio_Blog.model.EntradaBlog;
import com.example.Ejercicio_Blog.repository.IBlogRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.DataInput;

@Service
public class BlobServiceImpl implements IBlogService{

    private final IBlogRepository repository;
    private final ObjectMapper mapper;
    public BlobServiceImpl(IBlogRepository repository) {
        this.repository = repository;
        this.mapper = new ObjectMapper();
    }


    @Override
    public int create(EntradaBlogDto e) {
        if (repository.listAll().stream().anyMatch(x -> x.getId()==e.getId())){
            throw new IdExistenteException("Ya existe una entrada con este ID: " + e.getId() );
        }
        EntradaBlog entradaBlog = mapper.convertValue(e,EntradaBlog.class);
        repository.create(entradaBlog);
        return entradaBlog.getId();
    }
}
