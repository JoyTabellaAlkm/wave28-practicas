package com.blog.spring.repository.impl;

import com.blog.spring.model.EntradaBlog;
import com.blog.spring.repository.iBlogRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class blogRepositoryImpl implements iBlogRepository {
    private List<EntradaBlog> entradas;


    public blogRepositoryImpl() {
        this.entradas = new ArrayList<>();
    }

    @Override
    public EntradaBlog createBlog(EntradaBlog entrada) {
        entradas.add(entrada);
        return entrada;
    }

    @Override
    public boolean existsByID(int id) {
        return entradas.stream().anyMatch(x -> x.getId() == id);
    }

    @Override
    public EntradaBlog findById(int id) {
        return entradas.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
    }

    @Override
    public List<EntradaBlog> findAllEntradas() {
        return entradas;
    }
}
