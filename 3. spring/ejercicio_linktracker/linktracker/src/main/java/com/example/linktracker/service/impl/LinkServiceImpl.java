package com.example.linktracker.service.impl;

import com.example.linktracker.dto.LinkResponseDTO;
import com.example.linktracker.dto.MetricsResponseDTO;
import com.example.linktracker.entity.Link;
import com.example.linktracker.exception.customizedExceptions.NotFoundException;
import com.example.linktracker.exception.customizedExceptions.NotValidLinkException;
import com.example.linktracker.respository.ILinkRepository;
import com.example.linktracker.service.ILinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

@Service
public class LinkServiceImpl implements ILinkService {
    private static final String notValidExceptionMessage = "Link invalido";
    private static final String linkNotFoundExceptionMessage = "No se ha encontrado ningun link con ese id";

    @Autowired
    ILinkRepository linkRepository;

    @Override
    public LinkResponseDTO createLink(String link) {
        if (!isValidURL(link))
            throw new NotValidLinkException(notValidExceptionMessage);

        return new LinkResponseDTO(linkRepository.createLink(link));
    }

    @Override
    public String getLinkById(int id) {
        Link link = getEntityById(id);
        link.incrementRedirectsCount();
        return link.getLink();
    }

    @Override
    public MetricsResponseDTO getMetrics(int id) {
        Integer redirectsCount = linkRepository.getRedirectsCountById(id);

        if (redirectsCount == null)
            throw new NotFoundException(linkNotFoundExceptionMessage);

        return new MetricsResponseDTO(redirectsCount);
    }

    @Override
    public void invalidate(int id) {
        Link link = getEntityById(id);
        link.invalidate();
    }

    private Link getEntityById(int id){
        Link link = linkRepository.getLinkById(id);

        if (link == null)
            throw new NotFoundException(linkNotFoundExceptionMessage);
        if (!link.isValid())
            throw new NotValidLinkException(notValidExceptionMessage);

        return link;
    }

    private boolean isValidURL(String url) {
        try {
            new URL(url).toURI();
            return true;
        } catch (MalformedURLException e) {
            return false;
        } catch (URISyntaxException e) {
            return false;
        }
    }
}
