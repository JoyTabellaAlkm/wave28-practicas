package com.bootcamp.linktracker.repository;

import com.bootcamp.linktracker.dto.RequestPostCreacionLinkDto;
import com.bootcamp.linktracker.dto.ResponsePostCreacionLinkDto;
import com.bootcamp.linktracker.model.Link;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class LinkRepositoryImpl implements ILinkRepository{
    Map<Long, Link> links;

    public LinkRepositoryImpl() {
        links = new HashMap<>();

        Link linkGoogle = new Link("https://www.google.com", "google", 5);
        Link linkFacebook = new Link( "https://www.facebook.com", "facebook", 2);

        links.put(linkGoogle.getId(), linkGoogle);
        links.put(linkFacebook.getId(), linkFacebook);
    }

    @Override
    public Link crearLink(RequestPostCreacionLinkDto request) {
        Link nuevoLink = new Link(request.getLink(), request.getPassword(), 0);
        links.put(nuevoLink.getId(), nuevoLink);
        return nuevoLink;
    }

    @Override
    public Optional<Link> obtenerLinkPorId(Long id) {
        return Optional.ofNullable(links.get(id));
    }

    @Override
    public boolean modificarLink(Long linkIdAActualizar, Link linkUpdate) {
        if(!links.containsKey(linkIdAActualizar) || !linkIdAActualizar.equals(linkUpdate.getId())) {
            return false;
        }
        links.put(linkIdAActualizar, linkUpdate);
        return true;
    }
}
