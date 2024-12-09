package com.bootcamp.ejercicio_links.service;

import com.bootcamp.ejercicio_links.dto.LinkDto;
import com.bootcamp.ejercicio_links.dto.LinkMetricDto;
import com.bootcamp.ejercicio_links.entity.Links;
import com.bootcamp.ejercicio_links.exception.BadPasswordException;
import com.bootcamp.ejercicio_links.exception.NotFoundException;
import com.bootcamp.ejercicio_links.repository.ILinksRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LinkSericeImpl implements ILinksService{

    @Autowired
    private ILinksRepository linksRepository;
    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public Long create(LinkDto linkDto) {
        return linksRepository.save(objectMapper.convertValue(linkDto,Links.class));
    }

    @Override
    public String redirect(Long id, String password) {
        Links link = linksRepository.getLinkById(id);
        if (link == null) {
            throw new NotFoundException("Link incorrecto");
        }else if (!link.getPassword().equals(password) || link.getPassword().isEmpty()) {
            throw new BadPasswordException("Contraseña incorrecta!");
        }
        link.incrementarContador();
        linksRepository.update(link);
        return link.getLinkUrl();
    }

    @Override
    public LinkMetricDto metrics(Long id) {
        Links link = linksRepository.getLinkById(id);
        if (link == null) {
            throw new NotFoundException("Link incorrecto");
        }
        return new LinkMetricDto(link.getContador(), link.getLinkUrl());
    }

    @Override
    public void invalidate(Long id) {
        Links link = linksRepository.getLinkById(id);
        if (link == null) {
            throw new NotFoundException("Link no existe");
        }
        linksRepository.delete(id);
    }
}
