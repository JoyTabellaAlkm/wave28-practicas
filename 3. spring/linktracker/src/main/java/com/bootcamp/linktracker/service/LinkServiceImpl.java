package com.bootcamp.linktracker.service;

import com.bootcamp.linktracker.dto.LinkDTO;
import com.bootcamp.linktracker.exception.LinkNoEncontradoException;
import com.bootcamp.linktracker.exception.PasswordInvalidaException;
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
    public String redirect(Integer linkId, Optional<String> password) {
        Optional<LinkDTO> opt = linkDao.findById(linkId);
        if (opt.isEmpty())
            throw new LinkNoEncontradoException();

        LinkDTO link = opt.get();
        if (link.getPassword() != null
                && !(password.isPresent() && password.get().equals(link.getPassword()))) {
            throw new PasswordInvalidaException();
        }
        
        linkDao.update(link);
        return link.getLink();
    }

    @Override
    public void invalidate(Integer linkId) {
        Optional<LinkDTO> opt = linkDao.findById(linkId);
        if (opt.isEmpty())
            throw new LinkNoEncontradoException();
        linkDao.delete(opt.get());
    }
}
