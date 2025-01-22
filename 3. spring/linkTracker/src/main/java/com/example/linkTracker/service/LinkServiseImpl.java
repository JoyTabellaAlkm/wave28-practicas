package com.example.linkTracker.service;

import com.example.linkTracker.dto.*;
import com.example.linkTracker.exception.ErrorException;
import com.example.linkTracker.exception.IncorrectException;
import com.example.linkTracker.exception.NotFoundException;
import com.example.linkTracker.model.Link;
import com.example.linkTracker.repository.ILinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LinkServiseImpl implements ILinkService {

    @Autowired
    private ILinkRepository iLinkRepository;

    @Override
    public ResponseCreationLinkDto crearLink(ResquestCreateLinkDto request) {
        Link linkCreado = iLinkRepository.crearLink(request);
        return new ResponseCreationLinkDto(linkCreado.getId());
    }

    @Override
    public ResponseRedirectionDto redireccionLink(ResquestRedirectionDto request) {
        Optional<Link> linkObtenido = iLinkRepository.obtenerLinkPorId(request.getLinkId());
        if (linkObtenido.isEmpty()) {
            throw new NotFoundException("El id proporcionado no se corresponde con un link existente");
        }

        if (!linkObtenido.get().getPassword().equals(request.getPassword())) {
            throw new IncorrectException("Credenciales incorrectas, ingrese una válida");
        }

        Link linkIncrementado = linkObtenido.get();
        linkIncrementado.setCantRedirecciones(linkIncrementado.getCantRedirecciones() + 1);
        boolean updateExitoso = iLinkRepository.modificarLink(request.getLinkId(), linkIncrementado);

        if (!updateExitoso) {
            throw new ErrorException("Error inesperado al llamar al servicio de redirección");
        }

        return new ResponseRedirectionDto(linkObtenido.get().getLink());
    }

    @Override
    public ResponseMetricasDto obtenerMetricas(Long id) {
        Optional<Link> linkObtenido = iLinkRepository.obtenerLinkPorId(id);
        if (linkObtenido.isEmpty()) {
            throw new NotFoundException("El id proporcionado no se corresponde con un link existente");
        }

        return new ResponseMetricasDto(linkObtenido.get().getId(), linkObtenido.get().getLink(), linkObtenido.get().getCantRedirecciones());
    }

}
