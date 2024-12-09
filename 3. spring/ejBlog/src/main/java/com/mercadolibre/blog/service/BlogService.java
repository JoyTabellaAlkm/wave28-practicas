package com.mercadolibre.blog.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.blog.dto.BlogDTO;
import com.mercadolibre.blog.exception.DuplicatedBlogException;
import com.mercadolibre.blog.model.EntradaBlog;
import com.mercadolibre.blog.repository.IBlogRepository;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class BlogService  implements IBlogService{

    @Autowired
    private IBlogRepository blogRepository;

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public String create(BlogDTO dto) {

//        if(dto.getId() == null) {
//            throw new BadRequestException("No se puede crear un blog sin id");
//        }

        EntradaBlog blog = blogRepository.findById(dto.getId());
        if(blog != null) {
            throw new DuplicatedBlogException("Ya existe un blog con el id: " + dto.getId());
        }

//        EntradaBlog newBlog = objectMapper.convertValue(dto, EntradaBlog.class);
        EntradaBlog newBlog = new EntradaBlog();
        newBlog.setId(dto.getId());
        newBlog.setTitulo(dto.getTitulo());
        newBlog.setNombreAutor(dto.getNombreAutor());
        newBlog.setFechaPublicacion(LocalDate.parse(dto.getFechaPublicacion()));

        return blogRepository.create(newBlog);
    }
}
