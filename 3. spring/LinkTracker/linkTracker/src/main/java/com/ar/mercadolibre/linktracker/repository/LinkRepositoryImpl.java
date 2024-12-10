package com.ar.mercadolibre.linktracker.repository;

import com.ar.mercadolibre.linktracker.entity.Link;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Repository
public class LinkRepositoryImpl implements ILinkRepository{
    private List<Link> linkList;

    public LinkRepositoryImpl(List<Link> linkList) {
        this.linkList = linkList;
    }

    @Override
    public Optional<Link> findById(String linkId) {
        return linkList.stream().filter(link -> link.getLinkId().equals(linkId)).findFirst();
    }

    @Override
    public Link create(Link link) {
        linkList.add(link);
        link.setCounter(0);

        return link;
    }

    @Override
    public Optional<Link> findMetricsById(String linkID) {
        return linkList.stream().filter(link -> link.getLinkId().equals(linkID)).findFirst();
    }

    @Override
    public void delete(String linkID) {
        linkList = linkList.stream().filter(link -> !link.getLinkId().equals(linkID)).toList();
    }

    @Override
    public void updateMetrics(String linkId, String password) {
        linkList = linkList.stream().peek(link -> {
            if( link.getLinkId().equals(linkId) && ( link.getPassword() != null && !link.getPassword().isEmpty() || Objects.equals(link.getPassword(), password)) ){
                link.setCounter(link.getCounter() + 1);
            }
        }).toList();
    }

}
