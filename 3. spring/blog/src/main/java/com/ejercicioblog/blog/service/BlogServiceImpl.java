package com.ejercicioblog.blog.service;

import com.ejercicioblog.blog.dot.EntradaBlogDot;
import com.ejercicioblog.blog.repository.IBlogRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements IBlogService{
    @Autowired
    IBlogRepository repository;
    @Autowired
    ObjectMapper mapper;


    @Override
    public EntradaBlogDot filterById(int id) {
        return repository.stream
    }

    @Override
    public EntradaBlogDot agregarEntrada(EntradaBlogDot entrada) {
        return null;
    }

    @Override
    public List<EntradaBlogDot> listarTodas() {
        List<EntradaBlogDot> entradas =  repository.listarTodas()
                .stream()
                .map(e -> mapper.convertValue(e,EntradaBlogDot.class));
        return null;
    }
}
