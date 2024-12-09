package com.example.Ejercicio_LinkTracker.repository;

import com.example.Ejercicio_LinkTracker.model.Link;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class LinkRepository implements ILinkRepository{
    private Map<Integer, Link> listaLinks;

    public LinkRepository() {
        this.listaLinks = new HashMap<>();
    }

    @Override
    public int create(Link link) {
        listaLinks.put(link.getLinkId(),link);
        return link.getLinkId();
    }
    public Map<Integer, Link> getListaLinks(){
        return listaLinks;
    }
    public int getSize(){
        return listaLinks.size();
    }

}
