package com.mercadolibre.blogyoutuber.repository.impl;

import com.mercadolibre.blogyoutuber.dto.BlogDTO;
import com.mercadolibre.blogyoutuber.model.Blog;
import com.mercadolibre.blogyoutuber.repository.IBlogRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class BlogRepository implements IBlogRepository {

    HashMap<Long, Blog> listBlog = new HashMap<>();

    @Override
    public Blog crearBlog(Blog blog) {
        return listBlog.put(blog.getId(), blog );
    }

    @Override
    public HashMap<Long, Blog> obtenerBlogs() {
        return listBlog;
    }
}
