package com.start.linktraker.repository;

import com.start.linktraker.model.Link;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class LinkRepositoryImpl implements ILinkRepository {
    List<Link> listaLink= new ArrayList<>();

    @Override
    public int agregarLink(Link link) {
        listaLink.add(link);
        return link.getId();
    }







}
