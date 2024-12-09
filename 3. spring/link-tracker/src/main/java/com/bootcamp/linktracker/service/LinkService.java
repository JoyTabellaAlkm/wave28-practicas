package com.bootcamp.linktracker.service;

import com.bootcamp.linktracker.model.Link;
import com.bootcamp.linktracker.repository.LinkRepository;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class LinkService implements ILinkService {
    private final LinkRepository linkRepository;
    int index = 0;

    public LinkService(LinkRepository linkRepository) {
        this.linkRepository = linkRepository;
    }

    @Override
    public int createLink(String url) {
//        if(linkAlreadyExists()) throw new

        Link link = new Link(index, url);
        index++;

        return linkRepository.saveLink(link);
    }

    private boolean linkAlreadyExists(String url) {
        return linkRepository.getAllLinks()
                .stream()
                .anyMatch(link -> Objects.equals(link.getUrl(), url));
    }
}
