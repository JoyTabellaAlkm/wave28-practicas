package com.bootcamp.blog.service.impl;

import com.bootcamp.blog.dto.BlogDto;
import com.bootcamp.blog.exception.IdExistingException;
import com.bootcamp.blog.model.Blog;
import com.bootcamp.blog.repository.IBlogRepository;
import com.bootcamp.blog.repository.impl.BlogRepositoryImpl;
import com.bootcamp.blog.service.IBlogService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

@Service
public class BlogServiceImpl implements IBlogService{

    private final IBlogRepository repository;
    private final ObjectMapper mapper;
    public BlogServiceImpl(BlogRepositoryImpl repository) {
        this.repository = repository;
        this.mapper = new ObjectMapper();
    }
    @Override
    public int create(BlogDto b) {
        if (repository.listAll().stream().anyMatch(x -> x.getId()==b.getId())){
            throw new IdExistingException("Ya existe una entrada con este ID: " + b.getId() );
        }
        Blog blog = mapper.convertValue(b,Blog.class);
        repository.create(blog);
        return blog.getId();
    }
}
