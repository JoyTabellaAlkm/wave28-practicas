package com.example.blog.service.impl;

import com.example.blog.dto.EntradaBlogDTO;
import com.example.blog.entity.EntradaBlog;
import com.example.blog.exeption.BlogNotFoundExeption;
import com.example.blog.repository.EntradaBlogReposiory;
import com.example.blog.service.IEntradasBlog;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EntradaBlogImpl implements IEntradasBlog {
    @Autowired
    private EntradaBlogReposiory entradaBlogReposiory;
    private ObjectMapper objectMapper = new ObjectMapper();

    public EntradaBlogImpl(){
        objectMapper.registerModule(new JavaTimeModule());
    }

    public Optional<EntradaBlogDTO> createEntradaBlog(EntradaBlogDTO entrada){
        Optional<EntradaBlog> entradaId = entradaBlogReposiory.getAllEntradas().stream().filter(entradaBlog -> entradaBlog.getId()  == entrada.getId()).findFirst();
        if (entradaId.isPresent()){
            throw new BlogNotFoundExeption("Id ya existe");
        }
        else {
            EntradaBlog newEntrada = entradaBlogReposiory.createEntrada(
                    entrada
            );
            return Optional.of(objectMapper.convertValue(newEntrada, EntradaBlogDTO.class));
        }
    }

    @Override
    public Optional<EntradaBlogDTO> getEntradasById(int id) {
        Optional<EntradaBlog> entrada = entradaBlogReposiory.getAllEntradas().stream().filter(entradaBlog -> entradaBlog.getId()  == id).findFirst();
        if (entrada.isPresent()){
            return Optional.of(objectMapper.convertValue(entrada.get(), EntradaBlogDTO.class));
        }
        else {
            throw new BlogNotFoundExeption("Id no encontrado");
        }
    }

    @Override
    public List<EntradaBlogDTO> getEntradas() {
        return entradaBlogReposiory.getEntradas().stream().map(entradaBlog -> objectMapper.convertValue(entradaBlog, EntradaBlogDTO.class)).toList();
    }
}
