package com.bootcamp.linktracker.repository;

import com.bootcamp.linktracker.model.Link;

import java.util.List;

public interface ILinkRepository {
    int saveLink(Link link);

    List<Link> getAllLinks();
}
