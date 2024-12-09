package com.bootcamp.linktracker.service;

import com.bootcamp.linktracker.dto.LinkDTO;
import com.bootcamp.linktracker.exception.LinkNoEncontradoException;
import com.bootcamp.linktracker.repository.ILinkDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LinkServiceImpl implements ILinkService {

    @Autowired
    private ILinkDao linkDao;

    @Override
    public LinkDTO createLink(LinkDTO linkDTO) {
        linkDTO.setId(1);
        linkDao.getNewestLink().ifPresent(ultimo -> linkDTO.setId(ultimo.getId()+1));
        linkDao.create(linkDTO);
        return linkDTO;
    }

    @Override
    public Integer countRedirections(Integer linkId) {
        Optional<LinkDTO> link = linkDao.findById(linkId);
        if (link.isEmpty())
            throw new LinkNoEncontradoException();
        return link.get().getCantRedirecciones();
    }

    @Override
    public String redirect(Integer linkId) {
        Optional<LinkDTO> opt = linkDao.findById(linkId);
        if (opt.isEmpty())
            throw new LinkNoEncontradoException();

        LinkDTO link = opt.get();
        link.setCantRedirecciones(link.getCantRedirecciones()+1);
        linkDao.update(link);
        return link.getLink();
    }
}
