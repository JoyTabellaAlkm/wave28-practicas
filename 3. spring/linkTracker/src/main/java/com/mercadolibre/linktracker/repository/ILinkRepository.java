package com.mercadolibre.linktracker.repository;

import com.mercadolibre.linktracker.model.Link;

import java.util.Optional;

public interface ILinkRepository {
    Link createLink(Link link);

    Optional<Link> findById(Integer id);

    void invalidateLink(Link link);
}
