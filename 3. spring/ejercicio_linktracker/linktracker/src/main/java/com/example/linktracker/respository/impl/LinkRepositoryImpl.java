package com.example.linktracker.respository.impl;

import com.example.linktracker.entity.Link;
import com.example.linktracker.exception.customizedExceptions.NotFoundException;
import com.example.linktracker.exception.customizedExceptions.NotValidLinkException;
import com.example.linktracker.respository.ILinkRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class LinkRepositoryImpl implements ILinkRepository {
    private List<Link> links = new ArrayList<>();
    private int counterId = 1;

    @Override
    public int createLink(String link) {
        Link nuevoLink = new Link(counterId,link);
        counterId++;

        links.add(nuevoLink);
        return nuevoLink.getLinkId();
    }

    @Override
    public String getLinkById(int id) {
        return Objects.requireNonNull(links.stream()
                .filter(x -> x.getLinkId() == id)
                .findFirst()
                .orElse(null)).getLink();
    }
}
