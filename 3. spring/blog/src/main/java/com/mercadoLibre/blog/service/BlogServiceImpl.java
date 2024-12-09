package com.mercadoLibre.blog.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadoLibre.blog.dto.BlogDTO;
import com.mercadoLibre.blog.entity.Blog;
import com.mercadoLibre.blog.exception.AlreadyExistsException;
import com.mercadoLibre.blog.exception.NoContentException;
import com.mercadoLibre.blog.exception.NotFoundException;
import com.mercadoLibre.blog.repository.IBlogRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements IBlogService {
    final IBlogRepository blogRepository;

    private ObjectMapper mapper = new ObjectMapper();

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
        List<Blog> listaBlogs = blogRepository.traerTodosBlogs();
        if (listaBlogs.isEmpty()) {
            throw new NoContentException("Todavía no hay ningún blog.");
        }
        List<BlogDTO> listaBlogsDto = mapper.convertValue(listaBlogs, new TypeReference<List<BlogDTO>>() {
        });
        return listaBlogsDto;
    }
}
