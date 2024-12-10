package com.mercadolibre.linktracker.repository.impl;

import com.mercadolibre.linktracker.model.Link;
import com.mercadolibre.linktracker.repository.ILinkRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class LinkRepository implements ILinkRepository {

    private final List<Link> links;
    private Integer linkId;

    public LinkRepository() {
        links = new ArrayList<>();
        this.linkId = 1;
    }

    @Override
    public Link createLink(Link link) {
        link.setId(linkId++);
        link.setCounter(0);
        links.add(link);
        return link;
    }

    @Override
    public Optional<Link> findById(Integer id) {
        return links.stream()
                .filter(link -> link.getId().equals(id))
                .findFirst();
    }

    @Override
    public void invalidateLink(Link link) {
        links.remove(link);
    }
}
