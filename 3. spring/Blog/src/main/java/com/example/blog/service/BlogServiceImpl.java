package com.example.blog.service;

import com.example.blog.dto.BlogDtoRequest;
import com.example.blog.dto.BlogDtoResponse;
import com.example.blog.exception.BlogDuplicatedException;
import com.example.blog.exception.BlogNotFoundException;
import com.example.blog.model.Blog;
import com.example.blog.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements IBlogService{
    @Autowired
    private BlogRepository repositorio;

    @Override
    public List<BlogDtoResponse> obtenerblogs() {
        return repositorio.obtenerBlogs().stream().map( blg -> new BlogDtoResponse(
                blg.getTitulo(),
                blg.getAutor(),
                blg.getFechaPublicacion()
        )).toList();
    }

    @Override
    public BlogDtoResponse obtenerBlog(Integer id) {
        Blog blogtemp = repositorio.obtenerBlog(id);
        if(blogtemp != null){
            return new BlogDtoResponse(blogtemp.getTitulo(), blogtemp.getAutor(), blogtemp.getFechaPublicacion());
        }else {
            throw new BlogNotFoundException("El blog con Id: " + id + " no existe.");
        }
    }

    @Override
    public Integer agregarBlog(BlogDtoRequest nuevoBlog) {

        if(repositorio.obtenerBlog(nuevoBlog.getId()) == null){
            return repositorio.agregarBlog(new Blog(nuevoBlog.getId(), nuevoBlog.getTitulo(), nuevoBlog.getAutor(), nuevoBlog.getFechaPublicacion()));
        }else{
            throw new BlogDuplicatedException("El blog con el " + nuevoBlog.getId() + " ya existe");
        }
    }
}
