package com.mercadolibre.blog.repository;

import com.mercadolibre.blog.model.EntradaBlog;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public class EntradaBlogRepositoryImpl implements IEntradaBlogRepository{
    private HashMap<Long, EntradaBlog> mapEntradaBlock;
    private Long id;

    public EntradaBlogRepositoryImpl() {
        this.mapEntradaBlock = new HashMap<>();
        this.id = 1L;
    }

    @Override
    public Long addEntradaBlog(EntradaBlog entrada) {
        entrada.setId(id);
        mapEntradaBlock.put(id,entrada);
        return id++;
    }

    @Override
    public List<EntradaBlog> getAll() {
        return mapEntradaBlock.values().stream().toList();
    }

    @Override
    public EntradaBlog getById(Long id) {
        return mapEntradaBlock.get(id);
    }

    @Override
    public Boolean exists(EntradaBlog entrada) {
        return mapEntradaBlock.values().stream().anyMatch(e->e.equals(entrada));
    }

}
