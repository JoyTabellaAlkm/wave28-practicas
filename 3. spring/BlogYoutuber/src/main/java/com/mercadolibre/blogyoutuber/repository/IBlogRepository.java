package com.mercadolibre.blogyoutuber.repository;

import com.mercadolibre.blogyoutuber.model.Blog;

import java.util.HashMap;

public interface IBlogRepository {

    public Blog crearBlog(Blog blog);
    public HashMap<Long, Blog> obtenerBlogs();

}
