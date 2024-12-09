package com.example.blog.service;

import com.example.blog.dto.EntradaBlogDTO;
import com.example.blog.entity.EntradaBlog;

import java.util.List;
import java.util.Optional;

public interface IEntradasBlog {

    public Optional<EntradaBlogDTO> createEntradaBlog(EntradaBlogDTO entrada);

    public Optional<EntradaBlogDTO> getEntradasById(int id);

    public List<EntradaBlogDTO> getEntradas();

}
