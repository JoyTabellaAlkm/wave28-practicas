package com.example.blog.repository;

import com.example.blog.entity.EntradaBlog;

public interface IBlogRepository {
    public EntradaBlog findById(Integer id);

    public String create(EntradaBlog blog);
}
