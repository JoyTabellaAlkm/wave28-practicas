package com.ar.mercadolibre.linktracker.repository;

import com.ar.mercadolibre.linktracker.entity.Link;

import java.util.Optional;

public interface ILinkRepository {
    Optional<Link> findById(String linkId);
    Link create(Link link);
    Optional<Link> findMetricsById(String linkID);
    void delete(String linkID);
    void updateMetrics(String linkId, String password);
}
