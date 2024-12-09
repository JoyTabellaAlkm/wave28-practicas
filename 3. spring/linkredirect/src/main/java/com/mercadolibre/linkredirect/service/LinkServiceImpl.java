package com.mercadolibre.linkredirect.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.linkredirect.dto.LinkDtoRequest;
import com.mercadolibre.linkredirect.dto.LinkDtoResponse;
import com.mercadolibre.linkredirect.exception.IncorrectPasswordException;
import com.mercadolibre.linkredirect.exception.InvalidUrlFormatException;
import com.mercadolibre.linkredirect.exception.NotFoundException;
import com.mercadolibre.linkredirect.model.Link;
import com.mercadolibre.linkredirect.repository.ILinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.util.InvalidUrlException;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class LinkServiceImpl implements ILinkService{
    @Autowired
    private ILinkRepository linkRepository;
    @Autowired
    private ObjectMapper mapper;
    @Override
    public Long addLink(LinkDtoRequest linkDtoRequest) {
      Pattern validURLpattern = Pattern.compile("^(https?|ftp)://[^\s/$.?#].[^\s]*$");
        Matcher matcher = validURLpattern.matcher(linkDtoRequest.getLink());
        if(!matcher.matches()) throw new InvalidUrlFormatException("Ingrese una URL valida");
        Link link = mapper.convertValue(linkDtoRequest,Link.class);
        return linkRepository.addLink(link);
    }

    @Override
    public List<LinkDtoResponse> getAll() {
        return null;
    }


    @Override
    public LinkDtoResponse viewLinkById(Long id, String password) {
        Link link = linkRepository.getById(id);
        if(link== null) throw new NotFoundException("El link no existe");
        if(!link.getValid()) throw new InvalidUrlException("El link se encuentra invalidado");
        if(link.getPassword() != null && !password.equals(link.getPassword())) throw new IncorrectPasswordException("Contraseña invalida");
        link.setViewCount(link.getViewCount()+1);
        LinkDtoResponse linkDtoResponse = mapper.convertValue(link,LinkDtoResponse.class);
        return linkDtoResponse;
    }

    @Override
    public Long toggleLinkValid(Long id) {
        return null;
    }

    @Override
    public LinkDtoResponse getById(Long id){
        Link link = linkRepository.getById(id);
        if(link== null) throw new NotFoundException("El link no existe");
        LinkDtoResponse linkDtoResponse = mapper.convertValue(link,LinkDtoResponse.class);
        return linkDtoResponse;
    }
}
