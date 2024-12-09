package com.mercadolibre.blog.service.impl;

import com.mercadolibre.blog.dto.BlogDto;
import com.mercadolibre.blog.exception.AlreadyExistsException;
import com.mercadolibre.blog.exception.ResourceNotFoundException;
import com.mercadolibre.blog.model.Blog;
import com.mercadolibre.blog.repository.IBlogRepository;
import com.mercadolibre.blog.service.IBlogService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BlogService implements IBlogService {

    private final IBlogRepository blogRepository;
    private final ModelMapper modelMapper;

    public BlogService(IBlogRepository blogRepository, ModelMapper modelMapper) {
        this.blogRepository = blogRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public String save(BlogDto blog) throws AlreadyExistsException {
        if (blogRepository.findById(blog.getId()).isPresent()) {
            throw new AlreadyExistsException("Ya existe una entrada de blog con el id " + blog.getId());
        }
        return blogRepository.save(modelMapper.map(blog, Blog.class));
    }

    @Override
    public BlogDto findById(Integer id) throws ResourceNotFoundException {
        Optional<Blog> blog = blogRepository.findById(id);
        if (blog.isEmpty()) {
            throw new ResourceNotFoundException("No se encontró el blog con el id " + id);
        }
        return modelMapper.map(blog.get(), BlogDto.class);
    }

    @Override
    public List<BlogDto> finadAll() {
        return blogRepository.finadAll().stream()
                .map(blog -> modelMapper.map(blog, BlogDto.class))
                .toList();
    }
}
