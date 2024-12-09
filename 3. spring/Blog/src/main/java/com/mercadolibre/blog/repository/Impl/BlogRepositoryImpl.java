package com.mercadolibre.blog.repository.Impl;

import com.mercadolibre.blog.dto.BlogDTO;
import com.mercadolibre.blog.exception.DuplicatedIdException;
import com.mercadolibre.blog.model.EntradaBlog;
import com.mercadolibre.blog.repository.BlogRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BlogRepositoryImpl implements BlogRepository {
    private List<EntradaBlog> listEntradaBlog;
    public BlogRepositoryImpl() {
        this.listEntradaBlog = new ArrayList<>();
    }

    @Override
    public Long agregarEntradaBlog(EntradaBlog entradaBlog) {
        if (listEntradaBlog.stream().anyMatch(b->b.getId().equals(entradaBlog.getId())))
        {
            throw new DuplicatedIdException("El id "+entradaBlog.getId()+" ya existe en los blogs creados");
        }
        listEntradaBlog.add(entradaBlog);
        return entradaBlog.getId();
    }

    @Override
    public List<EntradaBlog> devolverBlogs() {
        return listEntradaBlog;
    }

    @Override
    public EntradaBlog devolverBlog(Long id) {
        return listEntradaBlog.stream().filter(blog->blog.getId().equals(id)).findFirst().orElse(null);
    }
}
