package com.mercadolibre.blog.service;

import com.mercadolibre.blog.dto.BlogDto;
import com.mercadolibre.blog.exception.AlreadyExistsException;
import com.mercadolibre.blog.exception.ResourceNotFoundException;

import java.util.List;

public interface IBlogService {
    String save(BlogDto blog) throws AlreadyExistsException;

    BlogDto findById(Integer id) throws ResourceNotFoundException;

    List<BlogDto> finadAll();
}
