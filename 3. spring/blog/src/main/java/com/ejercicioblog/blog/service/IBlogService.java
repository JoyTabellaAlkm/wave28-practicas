package com.ejercicioblog.blog.service;

import com.ejercicioblog.blog.dot.EntradaBlogDot;

import java.util.List;

public interface IBlogService {
    public EntradaBlogDot filterById(int id);
    public EntradaBlogDot agregarEntrada(EntradaBlogDot entrada);
    public List<EntradaBlogDot> listarTodas();
}
