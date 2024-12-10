package com.bootcamp.youtuber.service;

import com.bootcamp.youtuber.dto.EntradaBlogDto;

import java.util.List;

public interface BlogService {
    void create(EntradaBlogDto entradaBlog);
    EntradaBlogDto getBlogBy(Long id);
    List<EntradaBlogDto> getAllBlogs();
}
