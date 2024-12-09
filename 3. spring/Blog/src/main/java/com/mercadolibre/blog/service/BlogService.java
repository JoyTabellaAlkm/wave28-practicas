package com.mercadolibre.blog.service;

import com.mercadolibre.blog.dto.BlogDTO;

import java.util.List;

public interface BlogService {
    Long agregarEntradaBlog(BlogDTO entradaBlogDTO);
    List<BlogDTO> devolverBlogs();
    BlogDTO devolverBlog(Long id);
}
