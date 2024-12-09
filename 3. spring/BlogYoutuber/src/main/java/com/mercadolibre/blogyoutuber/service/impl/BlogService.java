package com.mercadolibre.blogyoutuber.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.blogyoutuber.dto.BlogDTO;
import com.mercadolibre.blogyoutuber.exceptions.BlogNotFoundException;
import com.mercadolibre.blogyoutuber.exceptions.IdAlreadyExistsException;
import com.mercadolibre.blogyoutuber.model.Blog;
import com.mercadolibre.blogyoutuber.repository.IBlogRepository;
import com.mercadolibre.blogyoutuber.repository.impl.BlogRepository;
import com.mercadolibre.blogyoutuber.service.IBlog;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class BlogService implements IBlog {

    @Autowired
    private IBlogRepository blogRepository;

    @Override
    public BlogDTO crearEntrada(BlogDTO blog) {
        ObjectMapper mapper = new ObjectMapper();
        Blog blogConverted = mapper.convertValue(blog, Blog.class);

        HashMap<Long, Blog> listaCompletaBlogs = blogRepository.obtenerBlogs();

        if(listaCompletaBlogs.containsKey(blogConverted.getId())){
            throw new IdAlreadyExistsException("El identificador ya existe");
        }

        blogRepository.crearBlog(blogConverted);
        return blog;
    }

    @Override
    public BlogDTO obtenerBlogPorId(Long id) {
        HashMap<Long, Blog> listaCompletaBlogs = blogRepository.obtenerBlogs();

        if(listaCompletaBlogs.containsKey(id)){
            return convertToDTO(listaCompletaBlogs.get(id));
        }else{
            throw new BlogNotFoundException("No se encontró un blog con el identificado proporcionado");
        }

    }

    @Override
    public HashMap<Long, BlogDTO> obtenerBlogs() {
        HashMap<Long, Blog> listaCompletaBlogs = blogRepository.obtenerBlogs();
        HashMap<Long, BlogDTO> listaBlogsDTO = new HashMap<>();
        for (Map.Entry<Long, Blog> entry : listaCompletaBlogs.entrySet()) {
            Long key = entry.getKey();
            Blog blog = entry.getValue();
            BlogDTO blogDTO = convertToDTO(blog);
            listaBlogsDTO.put(key, blogDTO);
        }

        return listaBlogsDTO;
    }



    public BlogDTO convertToDTO(Blog blog){
        BlogDTO blogDTO = new BlogDTO();
        blogDTO.setId(blog.getId());
        blogDTO.setTitle(blog.getTitle());
        blogDTO.setAuthor(blog.getAuthor());
        blogDTO.setDate(blog.getDate());
        return blogDTO;
    }
}
