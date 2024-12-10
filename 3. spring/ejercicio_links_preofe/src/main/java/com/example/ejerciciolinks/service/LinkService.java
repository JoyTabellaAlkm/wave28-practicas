package com.example.ejerciciolinks.service;

import com.example.ejerciciolinks.dto.LinkDTO;
import com.example.ejerciciolinks.dto.LinkMetricDTO;
import com.example.ejerciciolinks.entity.Link;
import com.example.ejerciciolinks.exception.BadPasswordException;
import com.example.ejerciciolinks.exception.NotFoundException;
import com.example.ejerciciolinks.repository.ILinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class LinkService implements ILinkService {

    @Autowired
    ILinkRepository repository;

    public Integer saveLink(LinkDTO linkDTO) {
        Link newLink = new Link();
        newLink.setLink(linkDTO.getUrl());
        newLink.setPassword(linkDTO.getPassword());
        newLink.setContadorEstadistica(0);
        return this.repository.saveLink(newLink);
    }

    @Override
    public void invalidateLink(Integer linkId) {
        if (repository.getLinkById(linkId) == null) {
            //Link inexistente
        }
        repository.deleteLink(linkId);
    }

    @Override
    public LinkMetricDTO getLinkMetrics(Integer linkId) {
        Link link = repository.getLinkById(linkId);

        LinkMetricDTO linkMetricDTO = new LinkMetricDTO(link.getLink(), link.getContadorEstadistica());
        return linkMetricDTO;
    }

    @Override
    public LinkDTO redirect(Integer linkId, String password) {
        Link link = repository.getLinkById(linkId);
        if (link == null) {
            throw new NotFoundException("Link incorrecto");
        }else if (!link.getPassword().equals(password) || link.getPassword().isEmpty()) {
                throw new BadPasswordException("Contraseña incorrecta!");//Error de contraseña
            }
            link.actualizarContador();
            repository.updateLink(link);
            return new LinkDTO(link.getLink(), link.getPassword());

        }

    }
}

