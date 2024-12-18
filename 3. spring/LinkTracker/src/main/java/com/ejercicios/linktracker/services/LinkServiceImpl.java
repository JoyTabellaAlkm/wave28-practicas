package com.ejercicios.linktracker.services;

import com.ejercicios.linktracker.dtos.requestDto.LinkDTO;
import com.ejercicios.linktracker.dtos.responseDto.LinkIdDTO;
import com.ejercicios.linktracker.exceptions.NotFoundException;
import com.ejercicios.linktracker.models.LinkModel;
import com.ejercicios.linktracker.repositories.ILinkRepository;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LinkServiceImpl implements ILinkService{

    @Autowired
    private ILinkRepository linkRepository;

    @Override
    public LinkIdDTO addLink(LinkDTO link) {
        LinkModel newLink = linkRepository.addLink(link.getUrl());
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return mapper.convertValue(newLink, LinkIdDTO.class);
    }

    @Override
    public String findLink(int id) {
        LinkModel link = linkRepository.findById(id);
        if(link == null){
            throw new NotFoundException("El id no corresponde a un link valido");
        }
        if(!validateLink(link.getUrl())){
            throw new NotFoundException("Link invalido");
        }
        linkRepository.countRedirect(id);
        return link.getUrl();
    }


    private boolean validateLink(String url){
        return true;
    }
}
