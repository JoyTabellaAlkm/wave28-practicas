package com.mercadolibre.blog.repository;

import com.mercadolibre.blog.model.EntradaBlog;

import java.util.List;

public interface BlogRepository {
    Long agregarEntradaBlog(EntradaBlog entradaBlog);
    List<EntradaBlog> devolverBlogs();
    EntradaBlog devolverBlog(Long id);
}
