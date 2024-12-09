package com.mercadolibre.Blog.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.Blog.dto.BlogDTO;
import com.mercadolibre.Blog.entity.EntradaBlogEntity;
import com.mercadolibre.Blog.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BlogServiceImpl implements IBlogService {
    @Autowired
    IBlogRepository repository;
    @Autowired
    ObjectMapper objeto;

    @Override
    public BlogDTO filterById(int id) {
        return objeto.convertValue(repository.filterById(id),BlogDTO.class);
    }

    @Override
    public BlogDTO agregarEntrada(BlogDTO entrada) {
        EntradaBlogEntity blog = repository.agregarEntrada(objeto.convertValue(entrada, EntradaBlogEntity.class));
        return objeto.convertValue(blog,BlogDTO.class);
    }

    @Override
    public List<BlogDTO> listarTodas() {
        List<BlogDTO> lista = repository.
                listarTodas().
                stream().
                map(x -> objeto.convertValue(x,BlogDTO.class)).
                toList();
        return lista;
    }
}

