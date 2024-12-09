package com.bootcamp.ejercicio_links.repository;

import com.bootcamp.ejercicio_links.entity.Links;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Repository
public class LinksRepositoryImpl implements ILinksRepository {
    private List<Links> linksList = new ArrayList<>();
    private Long contador = 0L;

    @Override
    public Long save(Links links) {
        contador++;
        links.setId(contador);
        linksList.add(links);
        return links.getId();
    }

    @Override
    public void update(Links links) {
        linksList.remove(links);
        linksList.add(links);
    }

    @Override
    public Links getLinkById(Long id) {
        return linksList.stream()
                .filter(links -> Objects.equals(links.getId(), id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void delete(Long id) {
        linksList = linksList.stream().filter(links -> links.getId() != id).toList();
    }
}
