package com.bootcamp.linktracker.service;

import com.bootcamp.linktracker.dto.*;
import com.bootcamp.linktracker.exception.ServiceErrorException;
import com.bootcamp.linktracker.exception.LinkNotFoundException;
import com.bootcamp.linktracker.exception.PasswordIncorrectException;
import com.bootcamp.linktracker.model.Link;
import com.bootcamp.linktracker.repository.ILinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LinkServiceImpl implements ILinkService{
    @Autowired
    private ILinkRepository linkRepository;

    @Override
    public ResponsePostCreacionLinkDto crearLink(RequestPostCreacionLinkDto request) {
        Link linkCreado = linkRepository.crearLink(request);
        return new ResponsePostCreacionLinkDto(linkCreado.getId());
    }

    @Override
    public ResponseRedireccion redireccionLink(RequestRedireccionDto request) {
        Optional<Link> linkObtenido = linkRepository.obtenerLinkPorId(request.getLinkId());
        if (linkObtenido.isEmpty()) {
            throw new LinkNotFoundException("El id proporcionado no se corresponde con un link existente");
        }

        if (!linkObtenido.get().getPassword().equals(request.getPassword())) {
            throw new PasswordIncorrectException("Credenciales incorrectas, ingrese una válida");
        }

        Link linkIncrementado = linkObtenido.get();
        linkIncrementado.setCantRedirecciones(linkIncrementado.getCantRedirecciones() + 1);
        boolean updateExitoso = linkRepository.modificarLink(request.getLinkId(), linkIncrementado);

        if (!updateExitoso) {
            throw new ServiceErrorException("Error inesperado al llamar al servicio de redirección");
        }

        return new ResponseRedireccion(linkObtenido.get().getLink());
    }

    @Override
    public ResponseMetricas obtenerMetricas(Long id) {
        Optional<Link> linkObtenido = linkRepository.obtenerLinkPorId(id);
        if (linkObtenido.isEmpty()) {
            throw new LinkNotFoundException("El id proporcionado no se corresponde con un link existente");
        }

        return new ResponseMetricas(linkObtenido.get().getId(), linkObtenido.get().getLink(), linkObtenido.get().getCantRedirecciones());
    }
}
