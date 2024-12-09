package com.bootcamp.ejercicioblog.repository;

import com.bootcamp.ejercicioblog.exception.EntradaBlogNoExisteException;
import com.bootcamp.ejercicioblog.exception.EntradaBlogYaExisteException;
import com.bootcamp.ejercicioblog.model.EntradaBlog;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class EntradaBlogRepositoryImpl implements IEntradaBlogRepository {
    private Map<Long, EntradaBlog> entradas;

    public EntradaBlogRepositoryImpl() {
        entradas = new HashMap<>();
        entradas.put(1L, new EntradaBlog(1L, "Libro 1","Jose", "2020-01-10"));
        entradas.put(2L, new EntradaBlog(2L, "Libro 2","Juan", "2020-10-11"));
        entradas.put(3L, new EntradaBlog(3L, "Libro 3","Juliana", "2020-03-15"));
    }

    @Override
    public Long crearEntradaBlog(EntradaBlog entradaBlog) {
        entradas.put(entradaBlog.getId(), entradaBlog);
        return entradaBlog.getId();
    }

    @Override
    public List<EntradaBlog> obtenerEntradas() {
        return entradas.values().stream().toList();
    }
}
