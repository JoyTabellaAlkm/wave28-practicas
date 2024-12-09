package com.bootcamp.ejercicio_links.service;

import com.bootcamp.ejercicio_links.dto.LinkDto;
import com.bootcamp.ejercicio_links.dto.LinkMetricDto;
import com.bootcamp.ejercicio_links.entity.Links;

public interface ILinksService {
    public Long create(LinkDto linkDto);
    public String redirect(Long id, String password);
    public LinkMetricDto metrics(Long id);
    public void invalidate(Long Id);
}
