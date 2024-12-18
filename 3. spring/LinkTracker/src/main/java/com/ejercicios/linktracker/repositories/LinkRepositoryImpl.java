package com.ejercicios.linktracker.repositories;

import com.ejercicios.linktracker.models.LinkModel;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class LinkRepositoryImpl implements ILinkRepository{

    private List<LinkModel> links;
    private int idCounter;

    public LinkRepositoryImpl(){
        this.links = new ArrayList<>();
        this.idCounter = 0;
    }


    @Override
    public LinkModel addLink(String link) {
        idCounter += 1;
        LinkModel newLink = new LinkModel(idCounter, link, 0);
        links.add(newLink);
        return newLink;
    }

    @Override
    public LinkModel findById(int id) {
        return links.stream().filter(l -> l.getId() == id).findFirst().orElse(null);
    }

    @Override
    public void countRedirect(int id) {
        links.stream().filter(l -> l.getId() == id).forEach(l-> l.setCounter(l.getCounter()+1));
    }
}
