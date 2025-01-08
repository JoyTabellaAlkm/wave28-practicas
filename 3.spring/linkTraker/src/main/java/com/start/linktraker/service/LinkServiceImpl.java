package com.start.linktraker.service;

import com.start.linktraker.dto.LinkDto;
import com.start.linktraker.exception.BadRequestException;
import com.start.linktraker.model.Link;
import com.start.linktraker.repository.ILinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LinkServiceImpl implements ILinkService{
    @Autowired
    private ILinkRepository linkRepository;

    boolean validacionRuta(LinkDto linkDto){

        return  linkDto.getUrl().contains(".com");
    }


    @Override
    public int crearLink(LinkDto linkDto) {
      if(!validacionRuta(linkDto)){
          throw new BadRequestException("No se encuentra el .com");
      }
      Link link = new Link();

      link.setId(linkDto.getId());
      link.setNombre(linkDto.getNombre());
      link.setUrl(linkDto.getUrl());
      link.setCantidadDeBusquedas(linkDto.getCantidadDeBusquedas());



      linkRepository.agregarLink(link);
        return  linkDto.getId();
    }



}
