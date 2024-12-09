package com.mercadolibre.blog.repository;

import com.mercadolibre.blog.model.EntradaBlog;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class BlogRepository implements IBlogRepository {
    private List<EntradaBlog> blogs = new ArrayList<>();


    @Override
    public EntradaBlog findById(Integer id) {
        Optional<EntradaBlog> blog =  blogs.stream().filter(b -> b.getId() == id).findFirst();
        return blog.orElse(null);
    }

    @Override
    public String create(EntradaBlog blog) {
        this.blogs.add(blog);
        return "Se creó el blog con id " + blog.getId() + " correctamente";
    }
}
