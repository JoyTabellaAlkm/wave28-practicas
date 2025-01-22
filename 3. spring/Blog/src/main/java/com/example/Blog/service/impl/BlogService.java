package com.example.Blog.service.impl;

import com.example.Blog.dto.EntradaBlogDto;
import com.example.Blog.entity.Blog;
import com.example.Blog.exceptions.IdRepeatException;
import com.example.Blog.exceptions.NotFoundException;
import com.example.Blog.respository.BlogRespository;
import com.example.Blog.service.IBlogService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BlogService implements IBlogService {

    @Autowired
    BlogRespository blogRepository;

    ObjectMapper mapper = new ObjectMapper();

    @Override
    public Long agregarNuevoBlog(EntradaBlogDto dto) {
        Boolean existe = blogRepository.getAllBlogs().stream().filter( b -> b.getId().equals(dto.getId())).findFirst().isPresent();
        if(existe){
            throw new IdRepeatException("El id ingresado ya existe");
        }else {
            blogRepository.addBlog(mapper.convertValue(dto, Blog.class));
        }
        return dto.getId();
    }

    @Override
    public EntradaBlogDto encontrarPorId(Long id) {
        Blog entradaBlog = blogRepository.getAllBlogs().stream().filter( e -> e.getId().equals(id)).findFirst().orElse(null);
        if (entradaBlog == null){
            throw new NotFoundException("No se encontraron entradas de blog con el id: " + id);
        }

        return mapper.convertValue(entradaBlog, EntradaBlogDto.class);
    }

    @Override
    public List<EntradaBlogDto> buscarTodos() {
        return blogRepository.getAllBlogs().stream().map(v -> mapper.convertValue(v, EntradaBlogDto.class)).collect(Collectors.toList());
    }
}
