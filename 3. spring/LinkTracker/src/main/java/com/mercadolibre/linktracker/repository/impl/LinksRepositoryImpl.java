package com.mercadolibre.linktracker.repository.impl;

import com.mercadolibre.linktracker.model.Link;
import com.mercadolibre.linktracker.repository.ILinksRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class LinksRepositoryImpl implements ILinksRepository {

    HashMap<Long, Link> listaLinks = new HashMap<>();

    @Override
    public Link crearLink(Link link) {
        return listaLinks.put(link.getId(), link);
    }

    @Override
    public HashMap<Long, Link> obtenerLinks() {
        return listaLinks;
    }
}
