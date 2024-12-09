package com.mercadolibre.blog.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.blog.dto.BlogDTO;
import com.mercadolibre.blog.model.EntradaBlog;
import com.mercadolibre.blog.repository.BlogRepository;
import com.mercadolibre.blog.repository.Impl.BlogRepositoryImpl;
import com.mercadolibre.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    BlogRepository blogRepository;

    ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public Long agregarEntradaBlog(BlogDTO entradaBlogDTO) {
        return blogRepository.agregarEntradaBlog(objectMapper.convertValue(entradaBlogDTO, EntradaBlog.class));
    }

    @Override
    public List<BlogDTO> devolverBlogs() {
        return blogRepository.devolverBlogs().stream()
                .map(blog -> objectMapper.convertValue(blog,BlogDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public BlogDTO devolverBlog(Long id) {
        return objectMapper.convertValue(blogRepository.devolverBlog(id),BlogDTO.class);
    }
}
