package com.example.blog.service;

import com.example.blog.dto.BlogDtoRequest;
import com.example.blog.dto.BlogDtoResponse;

import java.util.List;

public interface IBlogService {

    List<BlogDtoResponse> obtenerblogs();

    BlogDtoResponse obtenerBlog(Integer id);

    Integer agregarBlog (BlogDtoRequest nuevoBlog);
}
