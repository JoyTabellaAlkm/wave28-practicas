package com.blog.spring.service.impl;

import com.blog.spring.dto.EntradaBlogDTO;
import com.blog.spring.exceptions.ExistBlogException;
import com.blog.spring.exceptions.NotFoundEntrada;
import com.blog.spring.model.EntradaBlog;
import com.blog.spring.repository.iBlogRepository;
import com.blog.spring.service.iBlogService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class blogServiceImpl implements iBlogService {

    @Autowired
    private iBlogRepository repositorio;

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public EntradaBlogDTO createBlog(EntradaBlogDTO entrada) {
        if(repositorio.existsByID(entrada.getId()))
            throw new ExistBlogException("El id esta en uso");

        EntradaBlog entradaBlog = objectMapper.convertValue(entrada, EntradaBlog.class);
        repositorio.createBlog(entradaBlog);
        return entrada;
    }

    @Override
    public EntradaBlogDTO findByID(int id) {
        if(!repositorio.existsByID(id))
            throw new NotFoundEntrada("No existe una entrada con dicho id");

        EntradaBlog entrada = repositorio.findById(id);
        EntradaBlogDTO dto = objectMapper.convertValue(entrada, EntradaBlogDTO.class);

        return dto;
    }

    @Override
    public List<EntradaBlogDTO> findAllEntradas() {
        List<EntradaBlog> entradas = repositorio.findAllEntradas();
        if(entradas.isEmpty()){
            throw new NotFoundEntrada("No hay elementos para mostrar");
        }
        return objectMapper.convertValue(entradas, new TypeReference<List<EntradaBlogDTO>>() {});
    }
}
