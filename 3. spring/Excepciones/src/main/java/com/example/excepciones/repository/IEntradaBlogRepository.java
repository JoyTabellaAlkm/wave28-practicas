package com.example.excepciones.repository;

import com.example.excepciones.modelo.EntradaBlog;

import java.util.List;

public interface IEntradaBlogRepository {
    Boolean crearEntrada(EntradaBlog entradaBlog);
    EntradaBlog buscarPorId(Long id);
    List<EntradaBlog> obtenerBlogs();
}
