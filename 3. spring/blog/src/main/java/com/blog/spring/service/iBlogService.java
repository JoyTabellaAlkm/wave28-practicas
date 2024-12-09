package com.blog.spring.service;

import com.blog.spring.dto.EntradaBlogDTO;
import com.blog.spring.model.EntradaBlog;

import java.util.List;

public interface iBlogService {
    EntradaBlogDTO createBlog (EntradaBlogDTO entrada);

    EntradaBlogDTO findByID (int id);

    List<EntradaBlogDTO> findAllEntradas();
}
