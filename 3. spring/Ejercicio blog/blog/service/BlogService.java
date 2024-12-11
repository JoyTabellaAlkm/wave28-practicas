package com.example.blog.service;

import com.example.blog.dto.BlogDTO;
import com.example.blog.entity.EntradaBlog;
import com.example.blog.exception.DuplicatedBlogException;
import com.example.blog.repository.IBlogRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;

public class BlogService {
    @Autowired
    private IBlogRepository blogRepository;

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public String create(BlogDTO dto) {

        EntradaBlog blog = blogRepository.findById(dto.getId());
        if(blog != null) {
            throw new DuplicatedBlogException("Ya existe un blog con el id: " + dto.getId());
        }

        EntradaBlog newBlog = new EntradaBlog();
        newBlog.setId(dto.getId());
        newBlog.setTitulo(dto.getTitulo());
        newBlog.setNombreAutor(dto.getNombreAutor());
        newBlog.setFechaPublicacion(LocalDate.parse(dto.getFechaPublicacion()));

        return blogRepository.create(newBlog);
    }
}
