package com.example.youtubeblog.repository.impl;

import com.example.youtubeblog.model.EntradaBlog;
import com.example.youtubeblog.repository.IEntradaBlogRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class EntradaBlogRepository implements IEntradaBlogRepository {
    private List<EntradaBlog> entradaBlogList = new ArrayList<>();

    @Override
    public List<EntradaBlog> getAll() {
        return entradaBlogList;
    }

    @Override
    public Optional<EntradaBlog> getById(String id) {
        return entradaBlogList.stream()
                .filter(v -> v.getIdBlog().equals(id))
                .findFirst();
    }

    @Override
    public EntradaBlog save(EntradaBlog entradaBlog) {
        entradaBlogList.add(entradaBlog);
        return entradaBlog;
    }
}
