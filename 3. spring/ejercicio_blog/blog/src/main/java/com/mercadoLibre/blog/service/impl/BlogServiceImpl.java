package com.mercadoLibre.blog.service.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadoLibre.blog.dto.BlogDTO;
import com.mercadoLibre.blog.entity.Blog;
import com.mercadoLibre.blog.exception.customizedExceptions.AlreadyExistsException;
import com.mercadoLibre.blog.exception.customizedExceptions.NoContentException;
import com.mercadoLibre.blog.exception.customizedExceptions.NotFoundException;
import com.mercadoLibre.blog.repository.IBlogRepository;
import com.mercadoLibre.blog.service.IBlogService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements IBlogService {
    final IBlogRepository blogRepository;
    private final ObjectMapper mapper = new ObjectMapper();

    public BlogServiceImpl(IBlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    @Override
    public long agregarBlog(BlogDTO blogAAgregarDto) {
        if (blogRepository.blogExiste(blogAAgregarDto.getId()))
            throw new AlreadyExistsException("Ya existe un blog con ese id.");
        Blog blogAAgregar = mapper.convertValue(blogAAgregarDto, Blog.class);
        return blogRepository.agregarBlog(blogAAgregar);
    }

    @Override
    public BlogDTO buscarBlogPorId(long id) {
        Blog blogEncontrado = blogRepository.buscarBlogPorId(id);
        if (blogEncontrado == null)
            throw new NotFoundException("No existe un blog con ese id.");
        return mapper.convertValue(blogEncontrado, BlogDTO.class);
    }

    @Override
    public List<BlogDTO> traerTodosBlogs() {
        List<Blog> blogs = blogRepository.traerTodosBlogs();
        if (blogs.isEmpty())
            throw new NoContentException();

        return mapper.convertValue(blogs, new TypeReference<>() {});
    }
}
