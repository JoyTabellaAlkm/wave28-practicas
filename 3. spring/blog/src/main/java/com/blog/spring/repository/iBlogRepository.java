package com.blog.spring.repository;

import com.blog.spring.model.EntradaBlog;

import java.util.List;

public interface iBlogRepository {

    EntradaBlog createBlog(EntradaBlog entrada);

    boolean existsByID(int id);

    EntradaBlog findById(int id);

    List<EntradaBlog> findAllEntradas();
}
