package com.dario.dominguez.practicaentradablog.repository;

import com.dario.dominguez.practicaentradablog.entity.EntradaBlog;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BlogRepository {
    public List<EntradaBlog> listaBlogs = new ArrayList<>();

    public EntradaBlog addBlog(EntradaBlog vehicle) {
        try {
            listaBlogs.add(vehicle);
        }catch (Exception e){
            return null;
        }
        return vehicle;
    }

    public List<EntradaBlog> getAllBlogs() {
        return listaBlogs;
    }
}
