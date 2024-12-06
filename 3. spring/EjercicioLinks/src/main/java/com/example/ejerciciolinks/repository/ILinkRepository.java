package com.example.ejerciciolinks.repository;

import com.example.ejerciciolinks.entity.Link;
import com.example.ejerciciolinks.dto.LinkDTO;

import java.util.List;

public interface ILinkRepository {
    Integer saveLink(Link link);

    List<Link> getAllLink();

    Link getLinkByUrl(String url);

    Link getLinkById(Integer integer);

    Integer getLinkMetrics(Integer linkId);

    void deleteLink(Integer linkId);

    void updateLink(Link link);
}
