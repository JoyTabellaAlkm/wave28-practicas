package com.example.linkTracker.repository;

import com.example.linkTracker.dto.ResquestCreateLinkDto;
import com.example.linkTracker.model.Link;

import java.util.Optional;

public interface ILinkRepository {
    Link crearLink(ResquestCreateLinkDto request);

    Optional<Link> obtenerLinkPorId(Long id);

    boolean modificarLink(Long linkIdAActualizar, Link linkUpdate);
}
