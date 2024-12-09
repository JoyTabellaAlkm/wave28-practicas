package com.mercadolibre.blog.repository.impl;

import com.mercadolibre.blog.model.Blog;
import com.mercadolibre.blog.repository.IBlogRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class BlogRepository implements IBlogRepository {

    private final List<Blog> blogs;

    public BlogRepository(List<Blog> blogs) {
        this.blogs = blogs;
    }

    @Override
    public String save(Blog blog) {
        blogs.add(blog);
        return String.format("Entrada creada correctamente con id %d", blog.getId());
    }

    @Override
    public Optional<Blog> findById(Integer id) {
        return blogs.stream()
                .filter(blog -> blog.getId().equals(id))
                .findFirst();
    }

    @Override
    public List<Blog> finadAll() {
        return blogs;
    }
}
