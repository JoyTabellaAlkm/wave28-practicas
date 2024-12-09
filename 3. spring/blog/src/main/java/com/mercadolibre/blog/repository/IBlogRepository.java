package com.mercadolibre.blog.repository;

import com.mercadolibre.blog.model.Blog;

import java.util.List;
import java.util.Optional;

public interface IBlogRepository {
    String save(Blog blog);

    Optional<Blog> findById(Integer id);

    List<Blog> finadAll();
}
