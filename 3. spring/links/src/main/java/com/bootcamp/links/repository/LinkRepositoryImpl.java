package com.bootcamp.links.repository;

import com.bootcamp.links.model.Link;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class LinkRepositoryImpl implements ILinkRepository{

    HashMap<Integer, Link> listaLinks = new HashMap<>();

    @Override
    public Link agregarLink(Link link) {
        listaLinks.put(link.getLinkId(), link);
        return link;
    }

    @Override
    public Link obtenerLink(Integer linkId) {
        return listaLinks.get(linkId);
    }

}
