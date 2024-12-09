package com.bootcamp.ejercicio_links.repository;

import com.bootcamp.ejercicio_links.entity.Links;

public interface ILinksRepository {
    public Long save(Links links);
    public void update(Links links);
    public Links getLinkById(Long id);
    public void delete(Long id);
}
