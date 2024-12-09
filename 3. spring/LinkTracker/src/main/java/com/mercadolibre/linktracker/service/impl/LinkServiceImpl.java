package com.mercadolibre.linktracker.service.impl;

import com.mercadolibre.linktracker.dto.Request.LinkRequestDTO;
import com.mercadolibre.linktracker.dto.Response.LinkInvalidatedDTO;
import com.mercadolibre.linktracker.dto.Response.LinkMetricsResponseDTO;
import com.mercadolibre.linktracker.dto.Response.LinkResponseDTO;
import com.mercadolibre.linktracker.exceptions.InactiveResourceException;
import com.mercadolibre.linktracker.exceptions.InvalidURLException;
import com.mercadolibre.linktracker.exceptions.LinkNotFoundException;
import com.mercadolibre.linktracker.exceptions.MissingAttributesException;
import com.mercadolibre.linktracker.model.Link;
import com.mercadolibre.linktracker.repository.ILinksRepository;
import com.mercadolibre.linktracker.service.ILinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class LinkServiceImpl implements ILinkService {

    private AtomicLong lastId = new AtomicLong(0);

    @Autowired
    private ILinksRepository linksRepository;

    @Override
    public LinkResponseDTO crearLink(LinkRequestDTO link) {

        checkValidURL(link.getOriginalLink());

        Link linkToSave = new Link();
        linkToSave.setId(lastId.incrementAndGet());
        linkToSave.setOriginalLink(link.getOriginalLink());
        linkToSave.setCounter(0);
        linkToSave.setIsActive(true);
        linksRepository.crearLink(linkToSave);

        return new LinkResponseDTO(lastId.get());
    }

    @Override
    public String redirect(Long id) {

        HashMap<Long, Link> listaLinks = linksRepository.obtenerLinks();

        if(!listaLinks.containsKey(id)){
            throw new LinkNotFoundException("No se encontró un link con este id");
        }

        if(!listaLinks.get(id).getIsActive()){
            throw new InactiveResourceException("El link se encuentra inactivo");
        }

        checkValidURL(listaLinks.get(id).getOriginalLink());
        listaLinks.get(id).setCounter(listaLinks.get(id).getCounter() + 1);

        return listaLinks.get(id).getOriginalLink();

    }

    @Override
    public LinkMetricsResponseDTO obtenerMetricas(Long id) {

        HashMap<Long, Link> listaLinks = linksRepository.obtenerLinks();

        if(!listaLinks.containsKey(id)){
            throw new LinkNotFoundException("No se encontró un link con este id");
        }

        LinkMetricsResponseDTO response = new LinkMetricsResponseDTO();
        response.setLinkId(id);
        response.setOriginalLink(listaLinks.get(id).getOriginalLink());
        response.setCounter(listaLinks.get(id).getCounter());

        return response;

    }

    @Override
    public LinkInvalidatedDTO invalidarLink(Long id) {

        HashMap<Long, Link> listaLinks = linksRepository.obtenerLinks();

        if(!listaLinks.containsKey(id)){
            throw new LinkNotFoundException("No se encontró un link con este id");
        }

        Link link = listaLinks.get(id);
        link.setIsActive(false);

        LinkInvalidatedDTO invalidatedDTO = new LinkInvalidatedDTO();
        invalidatedDTO.setLinkId(link.getId());
        invalidatedDTO.setOriginalLink(link.getOriginalLink());
        invalidatedDTO.setActive(link.getIsActive());

        return invalidatedDTO;

    }

    public static void checkValidURL(String url) throws InvalidURLException {

        if(url == null) throw new MissingAttributesException("Se debe usar el campo originalLink y no puede ser nulo");

        try {
            URI uri = new URI(url);

            String scheme = uri.getScheme();
            if (scheme == null || (!scheme.equals("http") && !scheme.equals("https"))) {
                throw new InvalidURLException("El esquema de la URL debe ser 'http' o 'https'");
            }

            String host = uri.getHost();
            if (host == null || !host.contains(".") || host.indexOf('.') == host.length() - 1) {
                throw new InvalidURLException("Formato de URL inválido");
            }

        } catch (URISyntaxException e) {
            throw new InvalidURLException("Formato de URL inválido");
        }
    }

}
