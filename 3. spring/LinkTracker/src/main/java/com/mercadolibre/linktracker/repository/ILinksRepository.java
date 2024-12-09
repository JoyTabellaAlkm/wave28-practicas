package com.mercadolibre.linktracker.repository;

import com.mercadolibre.linktracker.model.Link;

import java.util.HashMap;

public interface ILinksRepository {
    public Link crearLink(Link link);
    public HashMap<Long, Link> obtenerLinks();
}
