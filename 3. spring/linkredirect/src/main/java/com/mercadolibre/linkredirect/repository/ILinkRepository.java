package com.mercadolibre.linkredirect.repository;

import com.mercadolibre.linkredirect.model.Link;

import java.util.List;
import java.util.Map;

public interface ILinkRepository {
    Long addLink(Link link);
    List <Link> getAll();
    Link getById(Long id);
}
