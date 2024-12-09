package com.example.blogyoutube.repository;

import com.example.blogyoutube.entity.EntradaBlog;
import com.example.blogyoutube.exception.ConflictException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class EntradaBlogRepositoryImpl implements IEntradaBlogRepository {
    private List<EntradaBlog> entradaBlogList = new ArrayList<>();

    @Override
    public List<EntradaBlog> findAll() {
        return entradaBlogList;
    }

    @Override
    public EntradaBlog create(EntradaBlog entradaBlog) {
        boolean hasConflict = entradaBlogList.stream()
                .anyMatch(e -> e.getId() == entradaBlog.getId());

        if (hasConflict)
            throw new ConflictException("No se pudo crear el recurso con el id: ." + entradaBlog.getId());

        entradaBlogList.add(entradaBlog);
        return entradaBlog;
    }

    @Override
    public Optional<EntradaBlog> find(long id) {
        return entradaBlogList.stream().filter(e -> e.getId() == id).findFirst();
    }
}
