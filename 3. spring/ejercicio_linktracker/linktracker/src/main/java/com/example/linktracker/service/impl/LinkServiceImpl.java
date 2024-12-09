package com.example.linktracker.service.impl;

import com.example.linktracker.dto.LinkResponseDTO;
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
    @Autowired
    ILinkRepository linkRepository;

    @Override
    public LinkResponseDTO createLink(String link) {
        if (!isValidURL(link))
            throw new NotValidLinkException("Link invalido");

        return new LinkResponseDTO(linkRepository.createLink(link));
    }

    @Override
    public String getLinkById(int id) {
        String link = linkRepository.getLinkById(id);
        if (link == null)
            throw new NotFoundException("no se ha encontrado el link con el id especificado");
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
