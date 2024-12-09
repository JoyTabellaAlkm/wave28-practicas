package com.example.excepciones.service;

import com.example.excepciones.dto.EntradaBlogDTO;
import com.example.excepciones.modelo.EntradaBlog;

import java.util.List;

public interface IEntradaBlogService {
 Boolean crearEntradaBlog (EntradaBlogDTO entradaBlog);
 EntradaBlogDTO obtenerBlogPorId( Long id);
 List<EntradaBlogDTO> obtenerBlogs();
}
