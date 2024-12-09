package com.example.Ejercicio_Blog.service;

import com.example.Ejercicio_Blog.dto.EntradaBlogDto;
import com.example.Ejercicio_Blog.model.EntradaBlog;

import java.util.List;

public interface IBlogService {
    public int create(EntradaBlogDto e);
}
