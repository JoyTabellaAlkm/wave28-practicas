package com.ar.mercadolibre.linktracker.service;

import com.ar.mercadolibre.linktracker.dto.request.LinkRequestDto;
import com.ar.mercadolibre.linktracker.dto.respoonse.LinkDto;
import com.ar.mercadolibre.linktracker.entity.Link;
import com.ar.mercadolibre.linktracker.exception.BadRequestException;
import com.ar.mercadolibre.linktracker.exception.ConflictException;
import com.ar.mercadolibre.linktracker.exception.ForbiddenException;
import com.ar.mercadolibre.linktracker.exception.NotFoundException;
import com.ar.mercadolibre.linktracker.repository.ILinkRepository;
import com.ar.mercadolibre.linktracker.repository.LinkRepositoryImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

@Service
public class LinkServiceImpl implements ILinkService{
    private final ILinkRepository linkRepository;
    private final ObjectMapper mapper;
    private final Environment env;
    private final LinkRepositoryImpl linkRepositoryImpl;

    public LinkServiceImpl(ILinkRepository linkRepository, Environment env, LinkRepositoryImpl linkRepositoryImpl) {
        this.linkRepository = linkRepository;
        this.env = env;
        this.mapper = new ObjectMapper();
        this.linkRepositoryImpl = linkRepositoryImpl;
    }

    @Override
    public LinkDto createMaskedUrl(String linkId, LinkRequestDto linkRequestDto) {
        Optional<Link> foundLink = linkRepository.findById(linkId);
        if(foundLink.isPresent()) {
            throw new ConflictException("Ya existe un link con ese Id");
        }
        validateUrl(linkRequestDto.getUrl());
        String maskedUrl = env.getProperty("my.app.baseUrl") +
                UUID.randomUUID().toString().substring(0, 8);
        String password;
        if(linkRequestDto.getPassword() == null) {
            password = null;
        }
        else {
            password = linkRequestDto.getPassword().orElse(null);
        }
        Link link = new Link(linkId, linkRequestDto.getUrl(), maskedUrl, password);
        Link createdLink = linkRepository.create(link);

        return mapper.convertValue(createdLink, LinkDto.class);
    }

    @Override
    public String redirect(String linkId, String password) {
        Optional<Link> link = linkRepository.findById(linkId);
        if(link.isEmpty()) {
            throw new NotFoundException("El id proporcionado no es válido");
        }
        if(link.get().getPassword() != null && !link.get().getPassword().equals(password)) {
            throw new ForbiddenException("No tiene permisos para redirigir");
        }
        linkRepository.updateMetrics(linkId, password);

        return link.get().getUrl();
    }

    @Override
    public long getMetricsById(String linkID) {
        Optional<Link> link = linkRepository.findMetricsById(linkID);
        if(link.isEmpty()) {
            throw new NotFoundException("No se ha encontrado ningún link con ese id");
        }

        return link.get().getCounter();
    }

    @Override
    public void delete(String linkID) {
        Optional<Link> link = linkRepository.findById(linkID);
        if(link.isEmpty()) {
            throw new NotFoundException("No se ha encontrado un link con ese id");
        }

        linkRepositoryImpl.delete(linkID);
    }

    private void validateUrl(String url) {
        String URL_REGEX =
            "^(https?:\\/\\/)" + // Protocolo
            "((([a-zA-Z\\d]([a-zA-Z\\d-]*[a-zA-Z\\d])*)\\.)+[a-zA-Z]{2,})" + // Dominio
            "(\\:\\d+)?(\\/[-a-zA-Z\\d%@_.~+&:]*)*" + // Puerto y path
            "(\\?[;&a-zA-Z\\d%@_.,~+&:=-]*)?" + // Query
            "(\\#[-a-zA-Z\\d_]*)?$"; // Fragmento
        Pattern pattern = Pattern.compile(URL_REGEX);
        Matcher matcher = pattern.matcher(url);

        if(!matcher.matches()) {
            throw new BadRequestException("La url no es válida");
        }
    }


}
