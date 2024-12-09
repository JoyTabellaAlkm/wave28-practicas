package com.bootcamp.linktracker.repository;

import com.bootcamp.linktracker.model.Link;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class LinkRepository implements ILinkRepository {
    ArrayList<Link> links = new ArrayList<>();

    @Override
    public int saveLink(Link link) {
        links.add(link);
        return link.getLinkId();
    }

    @Override
    public List<Link> getAllLinks() {
        return links;
    }


}
