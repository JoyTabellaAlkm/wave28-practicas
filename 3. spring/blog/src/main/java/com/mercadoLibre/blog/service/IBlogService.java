package com.mercadoLibre.blog.service;

import com.mercadoLibre.blog.dto.BlogDTO;

import java.util.List;

public interface IBlogService {
    long agregarBlog (BlogDTO blogAAgregar);
    BlogDTO buscarBlogPorId(long id);
    List<BlogDTO> traerTodosBlogs();
}
