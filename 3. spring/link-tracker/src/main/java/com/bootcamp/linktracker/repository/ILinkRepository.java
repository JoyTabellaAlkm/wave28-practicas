package com.bootcamp.linktracker.repository;

import com.bootcamp.linktracker.dto.RequestPostCreacionLinkDto;
import com.bootcamp.linktracker.dto.ResponsePostCreacionLinkDto;
import com.bootcamp.linktracker.model.Link;

import java.util.Optional;

public interface ILinkRepository {
    Link crearLink(RequestPostCreacionLinkDto request);

    Optional<Link> obtenerLinkPorId(Long id);

    boolean modificarLink(Long linkIdAActualizar, Link linkUpdate);
}
