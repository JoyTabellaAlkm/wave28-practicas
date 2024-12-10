package com.bootcamp.youtuber.repository;

import com.bootcamp.youtuber.dto.EntradaBlogDto;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Repository
public class EntradaBlogDaoImpl implements EntradaBlogDao{

    private final HashMap<Long, EntradaBlogDto> data = new HashMap<>();

    @Override
    public Optional<EntradaBlogDto> findById(Long id) {
        return Optional.ofNullable(data.get(id));
    }

    @Override
    public void save(EntradaBlogDto entradaBlog) {
        data.put(entradaBlog.getId(), entradaBlog);
    }

    @Override
    public List<EntradaBlogDto> findAll() {
        return data.values().stream().toList();
    }
}
