package com.mercadoLibre.blog.repository;

import com.mercadoLibre.blog.entity.Blog;

import java.util.List;

public interface IBlogRepository {
    long agregarBlog(Blog blogAAgregar);
    Blog buscarBlogPorId(long id);
    List<Blog> traerTodosBlogs();
    boolean blogExiste(long id);
}
